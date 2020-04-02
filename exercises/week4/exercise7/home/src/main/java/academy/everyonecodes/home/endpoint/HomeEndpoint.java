package academy.everyonecodes.home.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {

    @GetMapping
    String get(@Value("${homeTown}") String homeTown){
        return homeTown;
    }
}
