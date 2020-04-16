package academy.everyonecodes.tailrec.logic;

import academy.everyonecodes.tailrec.domain.Movie;
import academy.everyonecodes.tailrec.domain.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("tailored")
public class TailoredRecommendationsStore {
    private List<TailoredRecommendation> movies;

    TailoredRecommendationsStore(List<TailoredRecommendation> movies) {
        this.movies = movies;
    }

    public void setMovies(List<TailoredRecommendation> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovieForUser(String uuid) {
        return movies.stream()
                .filter(recommendation -> recommendation.getUserUuid().equals(uuid))
                .map(TailoredRecommendation::getMovie)
                .collect(Collectors.toList());
    }

    public void addToRecommendations(TailoredRecommendation recommendation) {
        movies.add(recommendation);
    }
}
