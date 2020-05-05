package academy.everyonecodes.validation.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TextServiceTest {
@Autowired
TextService textService;
    @Test
    void verifyValidLength() {
        String input = "tst";
        String result = textService.verifyLength(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    void validationFails(){
        String input = "tt";
        Assertions.assertThrows(ConstraintViolationException.class, () -> {textService.verifyLength(input);});
    }
}