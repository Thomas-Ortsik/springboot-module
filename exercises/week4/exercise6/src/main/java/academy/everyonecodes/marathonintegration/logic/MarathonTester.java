package academy.everyonecodes.marathonintegration.logic;

import academy.everyonecodes.marathonintegration.client.MarathonClient;
import academy.everyonecodes.marathonintegration.domain.Runner;
import academy.everyonecodes.marathonintegration.domain.TestResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarathonTester {
    private MarathonClient client;
    private Runner winner;
    private List<Runner> runners;

    public MarathonClient getClient() {
        return client;
    }

    public void setClient(MarathonClient client) {
        this.client = client;
    }

    public Runner getWinner() {
        return winner;
    }

    public void setWinner(Runner winner) {
        this.winner = winner;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    public TestResult integrationTest() {
        runners.stream()
                .forEach(runner -> client.postRunner(runner));
        if (client.getWinner().equals(winner)) {
            return new TestResult("Success", "Tests run correctly");
        }
        return new TestResult("Error", "Incorrect winner received");
    }
}
