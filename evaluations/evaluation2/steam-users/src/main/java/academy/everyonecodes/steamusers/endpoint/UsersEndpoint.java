package academy.everyonecodes.steamusers.endpoint;

import academy.everyonecodes.steamusers.domain.SteamUser;
import academy.everyonecodes.steamusers.logic.UsersService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersEndpoint {

    private final UsersService service;

    public UsersEndpoint(UsersService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_APP")
    SteamUser registerUser(@RequestBody SteamUser user) {
        return service.saveUser(user);
    }
}
