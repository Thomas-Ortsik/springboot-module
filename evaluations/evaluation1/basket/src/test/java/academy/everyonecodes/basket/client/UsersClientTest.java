package academy.everyonecodes.basket.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersClientTest {
    @Autowired
    UsersClient usersClient;
    @MockBean
    RestTemplate restTemplate;
    @Value("${url.users}")
    String url;

    @Test
    void getAccount() {
        String input = "test";
        usersClient.getAccount(input);
        Mockito.verify(restTemplate).getForObject(url+input, User.class);
    }
}