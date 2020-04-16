package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.repo.TweetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {
    private final TweetRepository repository;

    public TwitterService(TweetRepository repository) {
        this.repository = repository;
    }

    public List<Tweet> getAllOrdered() {
        return repository.findByOrderByTimestampDesc();
    }

    public List<Tweet> getAllByUser(String user) {
        return repository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet post(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        tweet.setLikes(0);
        tweet.setComments(new ArrayList<>());
        repository.save(tweet);
        return tweet;
    }

    public void likeTweet(String id) {
        Optional<Tweet> oTweet = repository.findById(id);
        if (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            tweet.addLike();
            repository.save(tweet);
        }
    }

    public void addComment(String id, String comment) {
        Optional<Tweet> oTweet = repository.findById(id);
        if (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            tweet.addComment(comment);
            repository.save(tweet);
        }
    }
}
