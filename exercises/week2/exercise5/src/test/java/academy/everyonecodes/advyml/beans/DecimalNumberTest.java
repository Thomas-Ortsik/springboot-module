package academy.everyonecodes.advyml.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DecimalNumberTest {
    @Autowired
    DecimalNumber decimalNumber;

    @Test
    void getNumber() {
        double expected = 1.618;
        double result = decimalNumber.getNumber();
        assertEquals(expected, result);
    }
}