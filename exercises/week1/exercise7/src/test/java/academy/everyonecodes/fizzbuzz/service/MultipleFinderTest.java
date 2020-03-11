package academy.everyonecodes.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
class MultipleFinderTest {

MultipleFinder multipleFinder = new MultipleFinder(3);
    @ParameterizedTest
    @CsvSource({
            "false, 4",
            "false, 1",
            "true, 3",
            "true, 6"
    })
    void isMultiple(boolean expected, int input) {
        boolean result = multipleFinder.isMultiple(input);
        Assertions.assertEquals(expected, result);
    }
}