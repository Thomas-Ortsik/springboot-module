package academy.everyonecodes.emergencynumbers.beans;

import academy.everyonecodes.emergencynumbers.interfaces.EmergencyNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FireEmergency implements EmergencyNumber {
    private final String name;
    private final int telephone;

    public FireEmergency(@Value("${emergency.fire.name}") String name, @Value("${emergency.fire.number}") int telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return telephone;
    }
}
