package academy.everyonecodes.drhouseaccountancy.translator;

import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import org.springframework.stereotype.Controller;

@Controller
public class PatientTranslator {
    public Patient toPatient(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment());
    }

    public PatientDTO toPatientDTO(Patient patient){
        return new PatientDTO(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()
        );
    }
}
