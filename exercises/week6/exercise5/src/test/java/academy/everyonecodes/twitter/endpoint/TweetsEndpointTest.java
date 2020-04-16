package academy.everyonecodes.twitter.endpoint;

import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TweetsEndpointTest {
@Autowired
    TestRestTemplate restTemplate;
@MockBean
    TwitterService service;

String url = "/tweets";

    @Test
    void getAll() {
        restTemplate.getForObject(url, List.class);
        Mockito.verify(service).getAllOrdered();
    }

    @Test
    void getFromUser() {
        restTemplate.getForObject(url+"/user/test", List.class);
        Mockito.verify(service).getAllByUser("test");
    }

    @Test
    void post() {
        Tweet input = new Tweet("bla", "bla", 2, List.of());
        restTemplate.postForObject(url, input, Tweet.class);
        Mockito.verify(service).post(input);
    }

    @Test
    void putLike() {
        restTemplate.put(url+"/test/likes", Tweet.class);
        Mockito.verify(service).likeTweet("test");
    }

    @Test
    void putComment() {
        restTemplate.put(url+"/test/comments", "testcomment", Tweet.class);
        Mockito.verify(service).addComment("test", "testcomment");
    }
}