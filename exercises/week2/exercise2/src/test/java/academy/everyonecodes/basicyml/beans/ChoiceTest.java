package academy.everyonecodes.basicyml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChoiceTest {
    @Autowired
    Choice choice;

    @Test
    void isChoice() {
        boolean result = choice.isChoice();
        Assertions.assertFalse(result);
    }
}