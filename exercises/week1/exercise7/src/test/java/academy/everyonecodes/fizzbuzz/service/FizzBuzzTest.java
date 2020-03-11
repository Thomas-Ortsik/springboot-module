package academy.everyonecodes.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FizzBuzzTest {
@Autowired
FizzBuzz fizzBuzz;
    @ParameterizedTest
    @CsvSource({
            "FizzBuzz, 15",
            "Fizz, 9",
            "Buzz, 10",
            "4, 4"
    })
    void apply(String expected, int input) {
        String result = fizzBuzz.apply(input);
        Assertions.assertEquals(expected, result);
    }
}