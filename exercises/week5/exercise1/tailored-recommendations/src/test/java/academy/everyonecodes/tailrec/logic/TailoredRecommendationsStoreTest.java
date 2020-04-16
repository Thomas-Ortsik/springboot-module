package academy.everyonecodes.tailrec.logic;

import academy.everyonecodes.tailrec.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsStoreTest {
    @Autowired
    TailoredRecommendationsStore store;

    @Test
    void getMovieForUser() {
        List<Movie> expected = List.of(new Movie("test", "testS"));
        List<Movie> result = store.getMovieForUser("1");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getMultipleMoviesForUser() {
        List<Movie> expected = List.of(new Movie("test2", "test2S"),
                new Movie("test3", "test3S"));
        List<Movie> result = store.getMovieForUser("2");
        Assertions.assertEquals(expected, result);
    }
}