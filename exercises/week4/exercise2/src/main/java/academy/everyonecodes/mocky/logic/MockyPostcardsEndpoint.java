package academy.everyonecodes.mocky.logic;

import academy.everyonecodes.mocky.domain.Postcard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {
    private final RestTemplate restTemplate;
    private final String firstCardURL;
    private final String secondCardURL;

    public MockyPostcardsEndpoint(RestTemplate restTemplate, @Value("${urls.postcards.postcardone}") String firstCardURL, @Value("${urls.postcards.postcardtwo}") String secondCardURL) {
        this.restTemplate = restTemplate;
        this.firstCardURL = firstCardURL;
        this.secondCardURL = secondCardURL;
    }

    @GetMapping("/1")
    Postcard getCardOne(){
        return restTemplate.getForObject(firstCardURL, Postcard.class);
    }

    @GetMapping("/2")
    List<Postcard> getCardTwo(){
        Postcard response = restTemplate.getForObject(secondCardURL, Postcard.class);
        return List.of(getCardOne(), response);
    }
}
