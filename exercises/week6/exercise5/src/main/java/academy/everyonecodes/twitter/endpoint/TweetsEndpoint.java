package academy.everyonecodes.twitter.endpoint;

import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {
    private final TwitterService service;

    public TweetsEndpoint(TwitterService service) {
        this.service = service;
    }

    @GetMapping
    List<Tweet> getAll(){
        return service.getAllOrdered();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getFromUser(@PathVariable String user){
        return service.getAllByUser(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet){
        return service.post(tweet);
    }

    @PutMapping("/{id}/likes")
    void putLike(@PathVariable String id){
        service.likeTweet(id);
    }
    @PutMapping("/{id}/comments")
    void putComment(@PathVariable String id, @RequestBody String comment){
        service.addComment(id, comment);
    }
}
