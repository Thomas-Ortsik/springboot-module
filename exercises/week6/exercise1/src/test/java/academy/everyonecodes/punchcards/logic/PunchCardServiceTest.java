package academy.everyonecodes.punchcards.logic;

import academy.everyonecodes.punchcards.domain.PunchCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PunchCardServiceTest {
@Autowired
PunchCardService service;
    @Test
    void signIn() {
        PunchCard result = service.signIn();
        assertNull(result.getId());
        assertNotNull(result.getDayOfTheWeek());
        assertNotNull(result.getTimeOfDay());
        System.out.println(result);
    }
}