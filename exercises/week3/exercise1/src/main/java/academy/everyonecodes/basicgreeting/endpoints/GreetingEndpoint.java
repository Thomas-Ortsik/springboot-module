package academy.everyonecodes.basicgreeting.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingEndpoint {
    @GetMapping
    String getMessage(){
        return "Hello there!";
    }
}
