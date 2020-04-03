package academy.everyonecodes.drhouseadmission.client;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosesClientTest {
    @Autowired
    DiagnosesClient client;
    @MockBean
    RestTemplate restTemplate;
    @Value("${url.diagnosis}")
    String url;

    @Test
    void send() {
        Patient test = new Patient("testUid", "Test", "testSymptoms");
        client.send(test);
        Mockito.verify(restTemplate).postForObject(url, test, Patient.class);
    }
}