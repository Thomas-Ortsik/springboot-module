package academy.everyonecodes.punchcards.runner;

import academy.everyonecodes.punchcards.domain.PunchCard;
import academy.everyonecodes.punchcards.logic.PunchCardService;
import academy.everyonecodes.punchcards.repo.PunchCardRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PunchCardRunner {
    private PunchCardService punchCardService;

    public PunchCardRunner(PunchCardService punchCardService) {
        this.punchCardService = punchCardService;
    }

    @Bean
    ApplicationRunner runPunchCard(PunchCardRepository punchCardRepository){
        return args -> {
            PunchCard card = punchCardService.signIn();
            punchCardRepository.save(card);
            System.out.println("Item saved: "+card);
        };
    }
}
