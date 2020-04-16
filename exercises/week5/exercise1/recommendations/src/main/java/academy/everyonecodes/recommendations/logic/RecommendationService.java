package academy.everyonecodes.recommendations.logic;

import academy.everyonecodes.recommendations.client.RecommendationClient;
import academy.everyonecodes.recommendations.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
     List<RecommendationClient> clients;

    public RecommendationService(List<RecommendationClient> clients) {
        this.clients = clients;
    }

    public List<Movie> getRecommendations(String uuid){
        return clients.stream()
                .map(client -> client.get(uuid))
                .filter(movies -> !movies.isEmpty())
                .findFirst().orElse(new ArrayList<>());
    }
}
