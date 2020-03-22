package academy.everyonecodes.basicproperties.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NaturalNumberTest {
@Autowired
NaturalNumber naturalNumber;

    @Test
    void getNumber() {
        int expected = 369;
        int result = naturalNumber.getNumber();
        Assertions.assertEquals(expected, result);
    }
}