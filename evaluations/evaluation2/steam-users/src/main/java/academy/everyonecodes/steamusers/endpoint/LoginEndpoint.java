package academy.everyonecodes.steamusers.endpoint;

import academy.everyonecodes.steamusers.logic.LoginService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginEndpoint {

    private final LoginService service;

    public LoginEndpoint(LoginService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_USER")
    String post() {
        return service.login();
    }
}
