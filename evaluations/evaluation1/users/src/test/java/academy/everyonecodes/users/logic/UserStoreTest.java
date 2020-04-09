package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserStoreTest {
    @Autowired
    UserStore store;

    User test1 = new User("test1", "test1@test.test", "standard account");
    User test2 = new User("test2", "test2@test.test", "premium account");
    User addTest = new User("testA", "test@A", "testAdd");

    @Test
    @Order(1)
    void getAllAccounts() {
        List<User> expected = List.of(test1, test2);
        List<User> result = store.getAllAccounts();
        assertEquals(expected, result);
    }

    @Test
    @Order(3)
    void addAccount() {
        List<User> expected = List.of(test1, test2, addTest);
        store.addAccount(addTest);
        List<User> result = store.getAllAccounts();
        assertEquals(expected, result);
    }

    @Test
    @Order(2)
    void getAccountByEmail() {
        String input = "test2@test.test";
        User expected = test2;
        Optional<User> oResult = store.getAccountByEmail(input);
        assertTrue(oResult.isPresent());
        assertEquals(expected, oResult.get());
    }
}