package academy.everyonecodes.couchpotato.endpoint;

import academy.everyonecodes.couchpotato.domain.Film;
import academy.everyonecodes.couchpotato.repo.FilmRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FilmEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    FilmRepository repository;

    String url = "/films";
    @Test
    @Order(8)
    void get() {
        restTemplate.getForObject(url, List.class);
        Mockito.verify(repository).findAll();
    }

    @Test
    @Order(1)
    void post() {
        Film film = new Film("Test5", 5);
        restTemplate.postForObject(url, film, Film.class);
    }


    @Test
    @Order(6)
    void postInvalidName() {
        Film film = new Film("", 3);
        restTemplate.postForObject(url, film, Film.class);
    }


    @Test
    @Order(5)
    void postInvalidScoreLow() {
        Film film = new Film("TestScoreLow", 0);
        restTemplate.postForObject(url, film, Film.class);
    }


    @Test
    @Order(4)
    void WaitWhyDidIOrderThemAgain() {
        Film film = new Film("TestScoreHigh", 6);
        restTemplate.postForObject(url, film, Film.class);
    }
    @Test
    @Order(3)
    void IsThisWereIShouldJustStartUsingSomethingLikeMethodSource() {
        Film film = new Film("Test1", 1);
        restTemplate.postForObject(url, film, Film.class);
    }


    @Test
    @Order(2)
    void NahTooLateButLetsAlsoTestWhatHappensIfTheNameWasAlreadySaved() {
        Film film = new Film("Test5", 3);
        restTemplate.postForObject(url, film, Film.class);
    }


}