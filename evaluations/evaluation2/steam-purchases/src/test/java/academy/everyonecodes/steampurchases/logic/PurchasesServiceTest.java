package academy.everyonecodes.steampurchases.logic;

import academy.everyonecodes.steampurchases.domain.Game;
import academy.everyonecodes.steampurchases.domain.Purchase;
import academy.everyonecodes.steampurchases.domain.User;
import academy.everyonecodes.steampurchases.repo.GameRepository;
import academy.everyonecodes.steampurchases.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PurchasesServiceTest {
    @Autowired
    PurchasesService service;
    @MockBean
    GameRepository gameRepository;
    @MockBean
    UserRepository userRepository;

    Purchase input = new Purchase("username", "name", "uuid", 3.14);
    Game game = new Game("uuid", "name", 3.14);

    @Test
    void savePurchaseCreatesNewUser() {
        Optional<User> oUser = Optional.empty();
        Mockito.when(userRepository.findByUsername(input.getUsername())).thenReturn(oUser);

        Purchase result = service.savePurchase(input);
        Assertions.assertEquals(input, result);

        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verify(gameRepository).save(game);

    }

    @Test
    void savePurchaseAddsToExistingUser() {
        User user2 = new User("username", new HashSet<>());
        user2.getGames().add(new Game("a","b",2.11));
        User user2addedGame = new User("username", Set.of(new Game("a","b",2.11), game));


        Mockito.when(userRepository.findByUsername(input.getUsername())).thenReturn(Optional.of(user2));

        Purchase result = service.savePurchase(input);
        Assertions.assertEquals(input, result);

        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verify(gameRepository).save(game);
        Mockito.verify(userRepository).save(user2addedGame);

    }

    @Test
    void getUsers() {
        service.getUsers();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    void getGames() {
        service.getGames();
        Mockito.verify(gameRepository).findAll();
    }
}