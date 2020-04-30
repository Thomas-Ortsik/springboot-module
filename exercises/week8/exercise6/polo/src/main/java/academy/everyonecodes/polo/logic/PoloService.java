package academy.everyonecodes.polo.logic;

import org.springframework.stereotype.Service;

@Service
public class PoloService {
    public String youTalkingToMe(String message){
        if (message.equals("Marco")){
            return "Polo";
        }
        return "What?";
    }
}
