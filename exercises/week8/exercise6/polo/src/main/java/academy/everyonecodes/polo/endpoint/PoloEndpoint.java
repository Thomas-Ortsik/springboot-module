package academy.everyonecodes.polo.endpoint;

import academy.everyonecodes.polo.logic.PoloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private final PoloService service;

    public PoloEndpoint(PoloService service) {
        this.service = service;
    }

    @PostMapping
    String post(@RequestBody String message){
        return service.youTalkingToMe(message);
    }
}
