package academy.everyonecodes.wizard.endpoint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WizardEndpointTest {
@Autowired
    TestRestTemplate restTemplate;

    @Test
    void getHome() {
        String expected = "http://localhost:9002/home";
        String result = restTemplate.getForObject("/wizard", String.class);
        Assertions.assertEquals(expected, result);
    }
}