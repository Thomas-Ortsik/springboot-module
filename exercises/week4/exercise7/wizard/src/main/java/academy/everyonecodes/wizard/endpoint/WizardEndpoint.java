package academy.everyonecodes.wizard.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {

    @GetMapping
    String getHome(@Value("${url.homeApp}") String homeUrl){
        return homeUrl;
    }
}
