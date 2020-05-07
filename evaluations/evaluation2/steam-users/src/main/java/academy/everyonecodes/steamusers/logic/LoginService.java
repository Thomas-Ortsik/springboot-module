package academy.everyonecodes.steamusers.logic;

import academy.everyonecodes.steamusers.domain.SteamUser;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login(){
        return "Login successful";
    }
}
