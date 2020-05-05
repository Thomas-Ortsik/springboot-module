package academy.everyonecodes.validation.endpoint;

import academy.everyonecodes.validation.domain.Artwork;
import academy.everyonecodes.validation.domain.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArtworksEndpointTest {
@Autowired
ArtworksEndpoint endpoint;
    @Test
    void postFailsWithTooFewStars() {
        Artwork input = new Artwork("test", new Rating(0));
        Assertions.assertThrows(ConstraintViolationException.class, () -> {endpoint.post(input);});
    }

    @Test
    void postFailsWithTooManyStars() {
        Artwork input = new Artwork("test", new Rating(6));
        Assertions.assertThrows(ConstraintViolationException.class, () -> {endpoint.post(input);});
    }


    @ParameterizedTest
    @CsvSource({"1", "5"})
    void postWorks(int testCase) {
        Artwork input = new Artwork("test", new Rating(testCase));
        Artwork result = endpoint.post(input);
        Assertions.assertEquals(input, result);
    }
}