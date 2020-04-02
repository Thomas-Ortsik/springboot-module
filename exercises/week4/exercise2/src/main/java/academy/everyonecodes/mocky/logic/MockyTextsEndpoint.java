package academy.everyonecodes.mocky.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {
    private final RestTemplate restTemplate;
    private final String textURL;
    private final String twoTextsURL;

    public MockyTextsEndpoint(RestTemplate restTemplate, @Value("${urls.texts.oneText}") String textURL, @Value("${urls.texts.twoTexts}") String twoTextURL) {
        this.restTemplate = restTemplate;
        this.textURL = textURL;
        this.twoTextsURL = twoTextURL;
    }

    @GetMapping("/1")
    String getText(){
        return restTemplate.getForObject(textURL, String.class);
    }

    @GetMapping("/2")
    String[] getTwoTexts(){
        return restTemplate.getForObject(twoTextsURL, String[].class);
    }

}
