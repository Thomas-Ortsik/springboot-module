package academy.everyonecodes.calculator.calc.operations;

import academy.everyonecodes.calculator.calc.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SubtractionTest {
    @Autowired
    Subtraction subtraction;

    @Test
    void calculate(){
        Expression input = new Expression("-", 1.0, 2.0);
        double result = subtraction.calculate(input);
        double expected = -1;
        Assertions.assertEquals(expected, result);
    }

}