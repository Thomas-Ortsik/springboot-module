package academy.everyonecodes.recommendations.client;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class TailoredRecommendationsClientTest {
    @Autowired
    TailoredRecommendationsClient client;
    @MockBean
    RestTemplate restTemplate;
    @Value("${url.tailored}")
    String url;

    String userUuid = "test";
    @Test
    void get() {
        client.get(userUuid);
        Mockito.verify(restTemplate).getForObject(url+userUuid, List.class);
    }
}