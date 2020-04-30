package academy.everyonecodes.languagebarriers.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InteractionsServiceTest {
@Autowired
InteractionsService service;

    @Test
    void increaseCount() {
        service.increaseCount();
        int result = service.getInteractionCount();
        int expected = 1;
        Assertions.assertEquals(expected, result);
        service.increaseCount();
        result = service.getInteractionCount();
        expected = 2;
        assertEquals(expected, result);


    }
}