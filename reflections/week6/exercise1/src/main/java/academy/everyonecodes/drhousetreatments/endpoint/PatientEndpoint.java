package academy.everyonecodes.drhousetreatments.endpoint;

import academy.everyonecodes.drhousetreatments.domain.Patient;
import academy.everyonecodes.drhousetreatments.logic.TreatmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final TreatmentService service;

    public PatientEndpoint(TreatmentService service) {
        this.service = service;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient){
        return service.postTreatment(patient);
    }
}
