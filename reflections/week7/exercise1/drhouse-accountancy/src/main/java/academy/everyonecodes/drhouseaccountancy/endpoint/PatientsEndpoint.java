package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.logic.CommunicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientsEndpoint {
    private final CommunicationService communicationService;

    public PatientsEndpoint(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @PostMapping
    PatientDTO post(@RequestBody PatientDTO patientDTO){
        return communicationService.postPatient(patientDTO);
    }
}
