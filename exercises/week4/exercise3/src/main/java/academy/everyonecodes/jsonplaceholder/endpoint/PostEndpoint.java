package academy.everyonecodes.jsonplaceholder.endpoint;

import academy.everyonecodes.jsonplaceholder.client.JsonPlaceholderClient;
import academy.everyonecodes.jsonplaceholder.domain.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {
    private final JsonPlaceholderClient client;

    public PostEndpoint(JsonPlaceholderClient client) {
        this.client = client;
    }

    @GetMapping
    List<Post> getPosts(){
        return client.getAllPosts();
    }
    @GetMapping("/{id}")
    Post getOnePost(@PathVariable String id){
        return client.getPost(id);
    }
    @PostMapping
    Post post(@RequestBody Post post){
        post = client.post(post);
        return post;
    }
    @PutMapping("/{id}")
    void put(@RequestBody Post newPost, @PathVariable int id){
        client.replace(id, newPost);
    }
    @DeleteMapping("/{id}")
    void deleteOnePost(@PathVariable String id){
        Post toDelete = getOnePost(id);
        client.deletePost(toDelete);
    }
}
