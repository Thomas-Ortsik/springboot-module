package academy.everyonecodes.thethievesden.endpoint;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasures")
public class TreasuresEndpoint {

    @GetMapping
    String get(){
        return "One Thousand and One Nights.";
    }
}
