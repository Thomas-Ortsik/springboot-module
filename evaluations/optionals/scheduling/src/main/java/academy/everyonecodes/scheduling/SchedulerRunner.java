package academy.everyonecodes.scheduling;

import academy.everyonecodes.scheduling.logic.Scheduler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerRunner {

    @Bean
    ApplicationRunner runScheduler(Scheduler scheduler){
        return args -> {
            scheduler.fixedDelay();
            scheduler.fixedRate();
            scheduler.cronMessage();
        };
    }
}
