package academy.everyonecodes.tailrec.client;

import academy.everyonecodes.tailrec.logic.TailoredRecommendationsStoreAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsStoreAssistantTest {
    @Autowired
    TailoredRecommendationsStoreAssistant client;
    @MockBean
    RestTemplate restTemplate;
    @Value("${url}")
    String url;


    @Test
    void getForID() {

    }

    @Test
    void post() {
    }
}