package academy.everyonecodes.drhouseadmission.endpoints;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import academy.everyonecodes.drhouseadmission.logic.Admission;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PatientEndpoint {
    private Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }

    @PostMapping("/patients")
    Patient post(@RequestBody Patient patient){
        admission.admit(patient);
        return patient;
    }
}
