package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.repo.TweetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TwitterServiceTest {
    @Autowired
    TwitterService service;
    @MockBean
    TweetRepository repository;

    Tweet testTweet = new Tweet("test", "test", 0, List.of());
    @Test
    void getAllOrdered() {
        service.getAllOrdered();
        Mockito.verify(repository).findByOrderByTimestampDesc();
    }

    @Test
    void getAllByUser() {
        service.getAllByUser("test");
        Mockito.verify(repository).findByUserOrderByTimestampDesc("test");
    }

    @Test
    void post() {
        service.post(testTweet);
        Mockito.verify(repository).save(testTweet);
        Assertions.assertNotNull(testTweet.getTimestamp());
    }

    @Test
    void likeTweet() {
        service.likeTweet("test");
        Mockito.verify(repository).findById("test");
    }

    @Test
    void addComment() {
        service.addComment("testID", "testComment");
        Mockito.verify(repository).findById("testID");
    }
}