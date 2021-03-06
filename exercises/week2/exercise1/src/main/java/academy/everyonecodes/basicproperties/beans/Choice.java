package academy.everyonecodes.basicproperties.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Choice {
    private final boolean choice;

    public Choice(@Value("${basic.choice}") boolean choice) {
        this.choice = choice;
    }

    public boolean isChoice() {
        return choice;
    }
}
