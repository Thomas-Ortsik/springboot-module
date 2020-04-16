package academy.everyonecodes.hotrn.logic;

import academy.everyonecodes.hotrn.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieStoreTest {
@Autowired
MovieStore movieStore;
    @Test
    void getMovies() {
        Set<Movie> expected = Set.of(new Movie("test1", "test1 synopsis"),
                new Movie("test2", "test2 synopsis"),
                new Movie("test3", "test3 synopsis"));
        Set<Movie> result = movieStore.getMovies();
        Assertions.assertEquals(expected, result);
    }
}