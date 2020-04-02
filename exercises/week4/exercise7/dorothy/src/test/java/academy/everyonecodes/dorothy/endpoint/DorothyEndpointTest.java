package academy.everyonecodes.dorothy.endpoint;

import academy.everyonecodes.dorothy.logic.Dorothy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DorothyEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    Dorothy dorothy;

    @Test
    void getHome() {
        restTemplate.getForObject("/dorothy", String.class);
        Mockito.verify(dorothy).findHome();
    }
}