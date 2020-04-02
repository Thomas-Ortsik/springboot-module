package academy.everyonecodes.loremipsum.logic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class LoremIpsumEndpoint {
    private RestTemplate restTemplate;
    private String url = "https://loripsum.net/api";

    public LoremIpsumEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/loremipsum")
    String getLoremIpsum() {
        return restTemplate.getForObject(url, String.class);
    }

}
