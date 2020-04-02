package academy.everyonecodes.polo.endpoint;

import academy.everyonecodes.polo.logic.Polo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Polo polo;

    @Test
    void post() {
        String url = "/polo";
        restTemplate.postForObject(url, "test", String.class);
        Mockito.verify(polo).returnMessage("test");
    }
}