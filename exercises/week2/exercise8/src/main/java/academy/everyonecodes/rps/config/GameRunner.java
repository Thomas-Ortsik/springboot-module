package academy.everyonecodes.rps.config;

import academy.everyonecodes.rps.beans.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {

    @Bean
    ApplicationRunner applicationRunner(Game game){
        return args -> game.play();
    }
}
