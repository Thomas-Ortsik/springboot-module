package academy.everyonecodes.recommendations.client;

import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Order(1)
public class TailoredRecommendationsClient implements RecommendationClient{
    private RestTemplate restTemplate;
    private String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate, @Value("${url.tailored}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public List<Movie> get(String uuid){
        return restTemplate.getForObject(url+uuid, List.class);
    }
}
