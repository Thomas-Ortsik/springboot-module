package academy.everyonecodes.tailrec.endpoint;

import academy.everyonecodes.tailrec.logic.TailoredRecommendationsStoreAssistant;
import academy.everyonecodes.tailrec.domain.Movie;
import academy.everyonecodes.tailrec.domain.TailoredRecommendation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TailoredRecommendationsEndpoint {
    private TailoredRecommendationsStoreAssistant client;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStoreAssistant client) {
        this.client = client;
    }

    @GetMapping("tailoredrecommendations/{useruuid}")
    List<Movie> getForUser(@PathVariable String useruuid) {
        return client.getForID(useruuid);
    }

    @PostMapping("tailoredrecommendations")
    TailoredRecommendation post(@RequestBody TailoredRecommendation recommendation) {
        return client.post(recommendation);
    }
}
