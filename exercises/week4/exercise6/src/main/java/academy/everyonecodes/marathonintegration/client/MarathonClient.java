package academy.everyonecodes.marathonintegration.client;

import academy.everyonecodes.marathonintegration.domain.Runner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class MarathonClient {
    private RestTemplate restTemplate;
    private String urlPost;
    private String urlGet;

    MarathonClient(){}

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setUrlPost(@Value("${url.marathon.post}") String urlPost) {
        this.urlPost = urlPost;
    }

    public void setUrlGet(@Value("${url.marathon.get}") String urlGet) {
        this.urlGet = urlGet;
    }

    public MarathonClient(RestTemplate restTemplate,
                          @Value("${url.marathon.post}") String urlPost,
                          @Value("${url.marathon.get}") String urlGet) {
        this.restTemplate = restTemplate;
        this.urlPost = urlPost;
        this.urlGet = urlGet;
    }

    public Runner getWinner(){
        return restTemplate.getForObject(urlGet, Runner.class);
    }

    public Runner postRunner(Runner runner){
        return restTemplate.postForObject(urlPost, runner, Runner.class);
    }
}
