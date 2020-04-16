package academy.everyonecodes.tailrec.logic;

import academy.everyonecodes.tailrec.domain.Movie;
import academy.everyonecodes.tailrec.domain.TailoredRecommendation;
import academy.everyonecodes.tailrec.logic.TailoredRecommendationsStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TailoredRecommendationsStoreAssistant {
    private TailoredRecommendationsStore store;

    public TailoredRecommendationsStoreAssistant(TailoredRecommendationsStore store) {
        this.store = store;
    }

    public List<Movie> getForID(String uuid) {
        return store.getMovieForUser(uuid);
    }

    public TailoredRecommendation post(TailoredRecommendation recommendation) {
        store.addToRecommendations(recommendation);
        return recommendation;
    }
}
