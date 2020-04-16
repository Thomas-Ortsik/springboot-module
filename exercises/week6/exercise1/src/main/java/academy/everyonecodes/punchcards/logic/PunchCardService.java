package academy.everyonecodes.punchcards.logic;

import academy.everyonecodes.punchcards.domain.PunchCard;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PunchCardService {
    public PunchCard signIn() {
        LocalDateTime timeOfSignIn = LocalDateTime.now();
        String day = timeOfSignIn.getDayOfWeek().name();
        String time = timeOfSignIn.toLocalTime().toString();
        return new PunchCard(day, time);
    }
}
