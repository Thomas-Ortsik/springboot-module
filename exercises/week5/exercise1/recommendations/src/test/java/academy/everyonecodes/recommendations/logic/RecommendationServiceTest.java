package academy.everyonecodes.recommendations.logic;

import academy.everyonecodes.recommendations.client.HotRightNowClient;
import academy.everyonecodes.recommendations.client.RecommendationClient;
import academy.everyonecodes.recommendations.client.TailoredRecommendationsClient;
import academy.everyonecodes.recommendations.domain.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RecommendationServiceTest {
    @Autowired
    RecommendationService recommendationService;
    @MockBean
    List<RecommendationClient> clients;
    @MockBean
    HotRightNowClient hrnClient;
    @MockBean
    TailoredRecommendationsClient trClient;


    String input = "test";
    List<Movie> movies = List.of(new Movie("test", "Test"), new Movie("test2", "Test2"));

    @Test
    void getRecommendations() {
        recommendationService.getRecommendations(input);
        Mockito.when(hrnClient.get(input)).thenReturn(movies);
    }
}