package academy.everyonecodes.marathonintegration.config;

import academy.everyonecodes.marathonintegration.domain.Runner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("testcase")
public class RunnerConfiguration {
    private List<Runner> runners;
    private Runner winner;

    public void setWinner(Runner winner) {
        this.winner = winner;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    @Bean
    Runner winner() {
        return winner;
    }

    @Bean
    List<Runner> runners() {
        return runners;
    }
}
