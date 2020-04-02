package academy.everyonecodes.marathonintegration.endpoint;

import academy.everyonecodes.marathonintegration.domain.TestResult;
import academy.everyonecodes.marathonintegration.logic.MarathonTester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marathon/integration")
public class MarathonIntegrationEndpoint {
    private final MarathonTester tester;

    public MarathonIntegrationEndpoint(MarathonTester tester) {
        this.tester = tester;
    }

    @GetMapping
    TestResult getTestResult(){
        return tester.integrationTest();
    }
}
