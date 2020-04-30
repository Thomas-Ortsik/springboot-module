package academy.everyonecodes.languagebarriers.endpoint;

import academy.everyonecodes.languagebarriers.service.LanguagesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/languages")
public class LanguagesEndpoint {
    private final LanguagesService languagesService;

    public LanguagesEndpoint(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping
    @Secured({"ROLE_USER"})
    String getAvailableLanguages(@Value("${languages.available}") String available) {
        return languagesService.availableLanguages(available);
    }

    @GetMapping("/german")
    String getGerman(@Value("${languages.german}") String german) {
        return languagesService.welcomeGerman(german);
    }

    @GetMapping("/english")
    String getEnglish(@Value("${languages.english}") String english) {
        return languagesService.welcomeEnglish(english);
    }
}
