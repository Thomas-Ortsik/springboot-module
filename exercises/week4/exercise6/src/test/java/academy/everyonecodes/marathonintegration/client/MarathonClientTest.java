package academy.everyonecodes.marathonintegration.client;

import academy.everyonecodes.marathonintegration.domain.Runner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MarathonClientTest {
@Autowired
    MarathonClient client;
@MockBean
RestTemplate restTemplate;
    @Value("${url.marathon.post}")
    String urlPost;
    @Value("${url.marathon.get}")
    String urlGet;

    @Test
    void getWinner() {
        client.getWinner();
        Mockito.verify(restTemplate).getForObject(urlGet, Runner.class);
    }

    @Test
    void postRunner() {
        Runner runner = new Runner("Test", Duration.ofSeconds(1));
        client.postRunner(runner);
        Mockito.verify(restTemplate).postForObject(urlPost, runner, Runner.class);
    }
}