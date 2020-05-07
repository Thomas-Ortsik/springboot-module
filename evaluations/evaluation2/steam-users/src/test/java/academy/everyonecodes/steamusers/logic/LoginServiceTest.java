package academy.everyonecodes.steamusers.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    LoginService service = new LoginService();
    @Test
    void login() {
        String expected = "Login successful";
        String result = service.login();
        Assertions.assertEquals(expected, result);
    }
}