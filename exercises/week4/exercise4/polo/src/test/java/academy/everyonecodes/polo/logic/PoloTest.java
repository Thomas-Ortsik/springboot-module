package academy.everyonecodes.polo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PoloTest {
    @Autowired
    Polo polo;


    @ParameterizedTest
    @CsvSource({
            "What?, marco",
            "What?, John",
            "Polo, Marco"
    })
    void returnMessage(String expected, String input) {
        String result = polo.returnMessage(input);
        Assertions.assertEquals(expected, result);
    }
}