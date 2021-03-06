package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Admission {
    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }

    public Patient admit(Patient patient) {
        String patientName = patient.getName();
        uuidProvider.provideUUID(patient);
        Map<String, String> patients = uuidProvider.getCacheSnapshot();
        patient = new Patient(patients.get(patientName), patientName, patient.getSymptoms());
        diagnosesClient.send(patient);
        return patient;
    }
}
