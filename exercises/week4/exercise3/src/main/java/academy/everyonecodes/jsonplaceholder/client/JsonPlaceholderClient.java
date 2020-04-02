package academy.everyonecodes.jsonplaceholder.client;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import academy.everyonecodes.jsonplaceholder.translator.PostTranslator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class JsonPlaceholderClient {
    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url;

    public JsonPlaceholderClient(RestTemplate restTemplate, PostTranslator postTranslator, @Value("${jsonplaceholder.posts.url}") String url) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
        this.url = url;
    }

    public List<Post> getAllPosts(){
        PostDTO[] request = restTemplate.getForObject(url, PostDTO[].class);
        return Stream.of(request).map(postDTO -> postTranslator.toPost(postDTO))
                .collect(Collectors.toList());
    }

    public Post getPost(String id){
        PostDTO request = restTemplate.getForObject(url + "/" + id, PostDTO.class);
        return postTranslator.toPost(request);
    }

    public Post post(Post post){
        PostDTO translatedPost = postTranslator.toPostDTO(post);
        PostDTO postedPost = restTemplate.postForObject(url, translatedPost, PostDTO.class);
        return postTranslator.toPost(postedPost);
    }

    public Post replace(int id, Post newPost){
        PostDTO translatedPost = postTranslator.toPostDTO(newPost);
        restTemplate.put(url + "/" + id, translatedPost);
        return newPost;
    }

    public void deleteAllPost(){
        restTemplate.delete(url);
    }

    public void deletePost(Post post){
        restTemplate.delete(url + "/" + post.getIdentifier());
    }



}
