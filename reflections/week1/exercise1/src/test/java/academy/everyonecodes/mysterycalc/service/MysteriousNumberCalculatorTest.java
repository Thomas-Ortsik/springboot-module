package academy.everyonecodes.mysterycalc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MysteriousNumberCalculatorTest {
@Autowired
MysteriousNumberCalculator numberCalculator;

    @Test
    void calculate() {
        int input = 3;
        String expected = "The mysterious number is 6";
        String result = numberCalculator.calculate(input);
        Assertions.assertEquals(expected, result);
    }
}