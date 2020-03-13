package academy.everyonecodes.mysterycalc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousAdditionTest {
MysteriousAddition mysteriousAddition = new MysteriousAddition(1);
    @Test
    void apply() {
        int input = 3;
        int expected = 4;
        int result = mysteriousAddition.apply(input);
        Assertions.assertEquals(expected, result);
    }
}