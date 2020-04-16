package academy.everyonecodes.recommendations.endpoint;

import academy.everyonecodes.recommendations.logic.RecommendationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendationEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    RecommendationService recommendationService;

    String url = "/recommendations/";
    @Test
    void get() {
        restTemplate.getForObject(url+"test", List.class);
        Mockito.verify(recommendationService).getRecommendations("test");
    }
}