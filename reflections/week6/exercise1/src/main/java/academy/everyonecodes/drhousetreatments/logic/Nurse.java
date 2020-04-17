package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.domain.Patient;
import academy.everyonecodes.drhousetreatments.domain.Treatment;
import org.springframework.stereotype.Service;

@Service
public class Nurse {
    public void provideTreatment(Patient patient){
        patient.setTreatment(chooseTreatment(patient));
    }

    private String chooseTreatment(Patient patient){
        return "spend one day in the hospital bed";
    }
}
