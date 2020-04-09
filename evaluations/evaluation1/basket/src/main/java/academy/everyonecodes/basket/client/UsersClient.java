package academy.everyonecodes.basket.client;

import academy.everyonecodes.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class UsersClient {
    private final RestTemplate restTemplate;
    private final String url;

    public UsersClient(RestTemplate restTemplate, @Value("${url.users}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Optional<User> getAccount(String email) {
        return Optional.ofNullable(restTemplate.getForObject(url + email, User.class));
    }
}
