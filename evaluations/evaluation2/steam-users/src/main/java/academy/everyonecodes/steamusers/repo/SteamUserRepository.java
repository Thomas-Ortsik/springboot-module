package academy.everyonecodes.steamusers.repo;

import academy.everyonecodes.steamusers.domain.SteamUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SteamUserRepository extends MongoRepository<SteamUser, String> {
    Optional<SteamUser> findByUsername(String username);
    Boolean existsByUsername(String username);
}
