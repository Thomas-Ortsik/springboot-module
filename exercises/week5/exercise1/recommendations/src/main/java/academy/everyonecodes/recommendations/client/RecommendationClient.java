package academy.everyonecodes.recommendations.client;

import academy.everyonecodes.recommendations.domain.Movie;

import java.util.List;

public interface RecommendationClient {
    public List<Movie> get(String userUd);
}
