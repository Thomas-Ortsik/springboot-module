package academy.everyonecodes.hotrn.logic;

import academy.everyonecodes.hotrn.domain.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@ConfigurationProperties("hot")
public class MovieStore {
    private Set<Movie> movies;

    public Set<Movie> getMovies() {
        return movies;
    }

    void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
