package academy.everyonecodes.advtypeb.endpoints;

import jdk.jfr.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CommunityEventEndpoint {
    private final List<Event> events;

    public CommunityEventEndpoint(List<Event> events) {
        this.events = events;
    }

    @GetMapping
    List<Event> events(){
        return events;
    }
}
