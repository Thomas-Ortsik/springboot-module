package academy.everyonecodes.marathon.logic;

import academy.everyonecodes.marathon.domain.Runner;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {
    private Set<Runner> runners;

    public MarathonService(Set<Runner> runners) {
        this.runners = runners;
    }

    public void add(Runner runner){
        runners.add(runner);
    }

    public Optional<Runner> findWinner(){
        return runners.stream().min(Comparator.comparing(Runner::getDuration));
    }

    public Set<Runner> getRunners() {
        return runners;
    }
}
