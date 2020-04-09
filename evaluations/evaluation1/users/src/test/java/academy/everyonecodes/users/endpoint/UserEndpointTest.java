package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    UserStore store;

    @Test
    void getUser() {
        restTemplate.getForObject("/users/test2@test.test", User.class);
        Mockito.verify(store).getAccountByEmail("test2@test.test");
    }
}