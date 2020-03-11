package academy.everyonecodes.agw.config;

import academy.everyonecodes.agw.service.AmazingGoodbyeWorld;
import academy.everyonecodes.agw.service.Goodbye;
import academy.everyonecodes.agw.service.World;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazingGoodbyeWorldConfiguration {
    @Bean
    Goodbye goodbye(){
        return new Goodbye();
    }
    @Bean
    World world(){
        return new World();
    }
    @Bean
    AmazingGoodbyeWorld amazingGoodbyeWorld(){
        return new AmazingGoodbyeWorld(goodbye(), world());
    }
}
