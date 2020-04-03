package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.client.DiagnosesClient;
import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdmissionTest {
    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient client;

    @Test
    void admit() {
        Patient input = new Patient(null, "Test", "cough");
        Patient result = admission.admit(input);
        Assertions.assertNotNull(result.getUuid());
        Mockito.verify(client).send(result);
    }
}