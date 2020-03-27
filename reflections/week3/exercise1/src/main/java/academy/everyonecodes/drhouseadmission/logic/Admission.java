package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Admission {
    private UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient){
        String patientName = patient.getName();
        uuidProvider.provideUUID(patient);
        Map<String, String> patients = uuidProvider.getCacheSnapshot();
        return new Patient(patients.get(patientName), patientName, patient.getSymptoms());
    }
}
