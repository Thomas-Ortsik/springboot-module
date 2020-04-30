package academy.everyonecodes.thehotelroom.endpoint;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {

    @GetMapping
    String get(){
        return "Welcome to the hotel";
    }

    @GetMapping("room")
    @Secured("ROLE_CUSTOMER")
    String getCustomer(){
        return "Welcome to your room.";
    }
}
