package academy.everyonecodes.ruc.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UpCounterTest {
    @Autowired
    UpCounter upCounter;

    @Test
    void count() {
        List<Double> input = List.of(0.7, 0.3, 2.1, 2.8, 53.6, 3.5);
        long expected = 3;
        long result = upCounter.count(input);
        Assertions.assertEquals(expected, result);
    }
}