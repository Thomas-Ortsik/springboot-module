package academy.everyonecodes.fizzbuzz.config;

import academy.everyonecodes.fizzbuzz.service.FizzBuzz;
import academy.everyonecodes.fizzbuzz.service.MultipleFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {
    @Bean
    FizzBuzz fizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive){
        return new FizzBuzz(multipleOfThree, multipleOfFive);
    }
}
