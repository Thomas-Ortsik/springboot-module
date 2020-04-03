package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Diagnosis;
import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {
    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Patient diagnose(Patient patient){
        String diagnosisName = diagnoses.stream()
                .filter(diagnosis -> matchesSymptoms(diagnosis, patient))
                .map(Diagnosis::getName)
                .findFirst().orElse("lupus");
        patient.setDiagnosis(diagnosisName);
        return patient;
    }

    private boolean matchesSymptoms(Diagnosis diagnosis, Patient patient){
        return patient.getSymptoms().equals(diagnosis.getSymptoms());
    }
}
