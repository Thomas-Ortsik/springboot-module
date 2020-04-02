package academy.everyonecodes.complexformula.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class FormulaClient {
    private final String url;
    private final RestTemplate restTemplate;

    public FormulaClient(@Value("${url.interactions}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public Integer getFormulaResult(Integer number){
        return restTemplate.postForObject(url, number, Integer.class);
    }

}
