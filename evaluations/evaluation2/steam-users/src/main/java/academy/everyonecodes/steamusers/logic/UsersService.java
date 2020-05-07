package academy.everyonecodes.steamusers.logic;

import academy.everyonecodes.steamusers.domain.SteamAppUser;
import academy.everyonecodes.steamusers.domain.SteamUser;
import academy.everyonecodes.steamusers.repo.SteamUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {
    private final SteamUserRepository repository;
    private final SteamAppUser steamapp;

    public UsersService(SteamUserRepository repository, SteamAppUser steamapp) {
        this.repository = repository;
        this.steamapp = steamapp;
        if (!repository.existsByUsername("steamapp")) {
            SteamUser user = steamapp.addAdmin();
            repository.save(user);
        }
    }

    public SteamUser saveUser(SteamUser user) {
        Optional<SteamUser> oUser = repository.findByUsername(user.getUsername());
        if (oUser.isPresent()) {
            return oUser.get();
        }
        user.setAuthorities(Set.of("ROLE_USER"));
        return repository.save(user);
    }
}
