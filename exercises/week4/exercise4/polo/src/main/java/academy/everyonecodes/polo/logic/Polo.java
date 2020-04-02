package academy.everyonecodes.polo.logic;

import org.springframework.stereotype.Service;

@Service
public class Polo {
        public String returnMessage(String receivedMessage){
            if (receivedMessage.equals("Marco")){
                return "Polo";
            }
            return "What?";
        }
}
