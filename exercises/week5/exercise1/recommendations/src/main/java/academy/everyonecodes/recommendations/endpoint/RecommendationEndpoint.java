package academy.everyonecodes.recommendations.endpoint;

import academy.everyonecodes.recommendations.domain.Movie;
import academy.everyonecodes.recommendations.logic.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {
    private RecommendationService recommendationService;

    public RecommendationEndpoint(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{uuid}")
    List<Movie> get(@PathVariable String uuid){
        return recommendationService.getRecommendations(uuid);
    }
}
