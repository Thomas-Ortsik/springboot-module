package academy.everyonecodes.hotrn.endpoint;

import academy.everyonecodes.hotrn.logic.MovieStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    MovieStore movieStore;

    @Test
    void get() {
        restTemplate.getForObject("/movies", Set.class);
        Mockito.verify(movieStore).getMovies();
    }
}