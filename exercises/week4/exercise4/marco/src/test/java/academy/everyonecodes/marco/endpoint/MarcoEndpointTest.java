package academy.everyonecodes.marco.endpoint;

import academy.everyonecodes.marco.client.PoloClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarcoEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    PoloClient client;

    @Test
    void get() {
        String url = "/marco/test";
        restTemplate.getForObject(url, String.class);
        Mockito.verify(client).post("test");
    }
}