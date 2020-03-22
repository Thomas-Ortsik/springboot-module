package academy.everyonecodes.emergencynumbers.beans;

import academy.everyonecodes.emergencynumbers.interfaces.EmergencyNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmergencyNumberProviderTest {
@Autowired
    EmergencyNumberProvider numberProvider;

    @ParameterizedTest
    @CsvSource({
            "122, Fire brigade",
            "133, Police",
            "112, General emergency",
            "112, i need a parrot"
    })
    void provide(int expected, String input) {
        int result = numberProvider.provide(input);
        Assertions.assertEquals(expected, result);
    }
}