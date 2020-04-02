package academy.everyonecodes.dorothy.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String urlWizard;

    public Dorothy(RestTemplate restTemplate,
                   @Value("${url.wizard}") String urlWizard) {
        this.restTemplate = restTemplate;
        this.urlWizard = urlWizard;
    }

    public String findHome() {
        String urlHome = restTemplate.getForObject(urlWizard, String.class);
        String homeResponse = restTemplate.getForObject(urlHome, String.class);
        return "My home is " + homeResponse;
    }
}
