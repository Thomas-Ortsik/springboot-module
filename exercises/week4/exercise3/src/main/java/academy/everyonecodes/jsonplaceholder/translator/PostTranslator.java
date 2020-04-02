package academy.everyonecodes.jsonplaceholder.translator;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.domain.PostDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class PostTranslator {

    public PostDTO toPostDTO(Post post) {
        return new PostDTO(post.getUser(), post.getIdentifier(), post.getTitle(), post.getContent());
        //return new PostDTO("test", "test", 1, 2);
    }

    public Post toPost(PostDTO postDTO) {
        return new Post(postDTO.getTitle(), postDTO.getBody(), postDTO.getUserId(), postDTO.getId());
    }
}
