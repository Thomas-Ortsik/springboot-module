package academy.everyonecodes.marathonintegration.logic;

import academy.everyonecodes.marathonintegration.client.MarathonClient;
import academy.everyonecodes.marathonintegration.domain.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MarathonTesterTest {
    @Autowired
    MarathonTester tester;
    @MockBean
    MarathonClient client;
    @MockBean
    Runner runner;
    @MockBean
    List<Runner> runners;



}