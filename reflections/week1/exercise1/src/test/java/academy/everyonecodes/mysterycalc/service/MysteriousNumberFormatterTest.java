package academy.everyonecodes.mysterycalc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MysteriousNumberFormatterTest {
@Autowired
MysteriousNumberFormatter numberFormatter;

    @Test
    void format() {
        int input = 4;
        String expected = "The mysterious number is 4";
        String result = numberFormatter.format(input);
        Assertions.assertEquals(expected, result);
    }
}