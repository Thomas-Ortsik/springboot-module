package academy.everyonecodes.drhousediagnoses.endpoint;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import academy.everyonecodes.drhousediagnoses.logic.DiagnosisRoom;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    DiagnosisRoom diagnosisRoom;

    @Test
    void post() {
        String url = "/patients";
        Patient input = new Patient("testUUID", "TestName", "testSymptoms", null);
        restTemplate.postForObject(url, input, Patient.class);
        Mockito.verify(diagnosisRoom).diagnose(input);
    }
}