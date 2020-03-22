package academy.everyonecodes.emergencynumbers.beans;

import academy.everyonecodes.emergencynumbers.interfaces.EmergencyNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmergencyNumberProvider {
    private final List<EmergencyNumber> emergencyNumbers;
    private final int generalNumber;

    public EmergencyNumberProvider(List<EmergencyNumber> emergencyNumbers, @Value("${emergency.general.number}") int generalNumber) {
        this.emergencyNumbers = emergencyNumbers;
        this.generalNumber = generalNumber;
    }

    public int provide(String name){
        return emergencyNumbers.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equals(name))
                .map(EmergencyNumber::getNumber)
                .findFirst().orElse(generalNumber);
    }
}
