package academy.everyonecodes.ruc.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "SAME, 0.5",
            "SAME, 0",
            "SAME, -0.5",
            "SAME, 1",
            "SAME, -1",
            "UP, 0.7",
            "UP, 1.9",
            "UP, -0.3",
            "DOWN, 0.2",
            "DOWN, 1.4",
            "DOWN, -0.8",
            "DOWN, -1.7"
    })
    void indicate(String expected, double input) {
        String result = upDownIndicator.indicate(input);
        Assertions.assertEquals(expected, result);
    }
}