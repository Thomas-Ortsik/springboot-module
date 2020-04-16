package academy.everyonecodes.recommendations.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Order(2)
public class HotRightNowClient implements RecommendationClient{
    private RestTemplate restTemplate;
    private String url;

    public HotRightNowClient(RestTemplate restTemplate, @Value("${url.hot}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }


    @Override
    public List<Movie> get(String userUuid) {
        return restTemplate.getForObject(url, List.class);
    }
}
