package academy.everyonecodes.calculator.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTest {
    @Autowired
    Calculator calculator;

    @ParameterizedTest
    @CsvSource({
            "3, 1 + 2",
            "2, 1 * 2",
            "0.5, 1 / 2",
            "-1, 1 - 2"
    })
    void calculate(double expected, String input) {
        double result = calculator.calculate(input);
        Assertions.assertEquals(expected, result);
    }
@Test
    void calculateUnknownOp() {
        String input = "1 & 2";
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(input);
        });
    }
@Test
    void calculateDivideByZero() {
        String input = "1 / 0";
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(input);
        });
    }
}