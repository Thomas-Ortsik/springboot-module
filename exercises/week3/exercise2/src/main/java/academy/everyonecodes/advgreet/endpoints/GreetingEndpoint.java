package academy.everyonecodes.advgreet.endpoints;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingEndpoint {
    @GetMapping
    String getMessage(@Value("${message}") String message){
        return message;
    }
}
