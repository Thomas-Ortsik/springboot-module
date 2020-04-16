package academy.everyonecodes.hotrn.endpoint;

import academy.everyonecodes.hotrn.domain.Movie;
import academy.everyonecodes.hotrn.logic.MovieStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieEndpoint {
    private MovieStore movieStore;

    MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    @GetMapping
    Set<Movie> get() {
        return movieStore.getMovies();
    }
}
