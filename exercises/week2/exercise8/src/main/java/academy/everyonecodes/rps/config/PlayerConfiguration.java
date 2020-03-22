package academy.everyonecodes.rps.config;

import academy.everyonecodes.rps.beans.MoveUtils;
import academy.everyonecodes.rps.data.Move;
import academy.everyonecodes.rps.interfaces.Player;
import academy.everyonecodes.rps.service.Computer;
import academy.everyonecodes.rps.service.Human;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {
    @Bean
    Player player1(MoveUtils moveUtils) {
        return new Human(moveUtils);
    }

    @Bean
    Player player2(List<Move> moves) {
        return new Computer(moves);
    }
}

