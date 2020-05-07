package academy.everyonecodes.steamusers.logic;

import academy.everyonecodes.steamusers.domain.SteamAppUser;
import academy.everyonecodes.steamusers.domain.SteamUser;
import academy.everyonecodes.steamusers.repo.SteamUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersServiceTest {
    @Autowired
    UsersService service;
    @MockBean
    SteamUserRepository repository;
    @MockBean
    SteamAppUser steamApp;

    SteamUser steamUser = new SteamUser("test", "test", Set.of("test"));
    SteamUser steamUser2 = new SteamUser("test", "test2", Set.of("test2"));

    @Test
    void saveUserNameAlreadySavedReturnsSavedUser() {
        Mockito.when(repository.findByUsername(steamUser.getUsername())).thenReturn(Optional.of(steamUser2));
        SteamUser result = service.saveUser(steamUser);
        SteamUser expected = steamUser2; //works in this case, because we should not continue with setting new Authorities.
        Assertions.assertEquals(expected, result);
    }

    @Test
    void saveNewUser() {
        Mockito.when(repository.findByUsername(steamUser.getUsername())).thenReturn(Optional.empty());
        SteamUser result = service.saveUser(steamUser);
        SteamUser expected = new SteamUser("test", "test", Set.of("ROLE_USER"));
        Mockito.verify(repository).save(expected);
    }
}