package academy.everyonecodes.marcopolo.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MarcoPoloEndpoint {

    @GetMapping("/{text}")
    String get(@PathVariable String text){
        if (text.equals("Marco")){
            return "Polo";
        }
        return "What?";
    }
}
