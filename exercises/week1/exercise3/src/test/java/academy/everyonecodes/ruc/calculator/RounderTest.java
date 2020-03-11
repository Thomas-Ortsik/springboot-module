package academy.everyonecodes.ruc.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RounderTest {
    @Autowired
    Rounder rounder;

    @Test
    void roundUp() {
        double input = 3.5;
        double expected = 4;
        double result = rounder.roundUp(input);
        assertEquals(expected, result);
    }

    @Test
    void roundDown() {
        double input = 3.5;
        double expected = 3;
        double result = rounder.roundDown(input);
        assertEquals(expected, result);
    }
}