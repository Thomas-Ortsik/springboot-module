package academy.everyonecodes.marathonintegration.endpoint;

import academy.everyonecodes.marathonintegration.domain.TestResult;
import academy.everyonecodes.marathonintegration.logic.MarathonTester;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarathonIntegrationEndpointTest {
@Autowired
    TestRestTemplate restTemplate;
@MockBean
    MarathonTester tester;

    @Test
    void getTestResult() {
        String url = "/marathon/integration";
        restTemplate.getForObject(url, TestResult.class);
        Mockito.verify(tester).integrationTest();
    }
}