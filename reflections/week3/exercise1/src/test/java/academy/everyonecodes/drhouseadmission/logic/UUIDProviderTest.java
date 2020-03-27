package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UUIDProviderTest {
@Autowired
UUIDProvider provider;


    @Test
    void findUUIDWithNewPatient() {
        Patient input = new Patient("", "Test", "cough");
        provider.provideUUID(input);
        String expected = "1";
        String result = provider.findUUID("Test");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findUUIDWithKnownPatient() {
        Patient filler = new Patient("", "filler", "cough");
        provider.provideUUID(filler);
        Patient filler2 = new Patient("", "filler2", "cough");
        provider.provideUUID(filler2);
        Patient input = new Patient("", "Test", "dabs");
        provider.provideUUID(input);
        Patient input3 = new Patient("", "Test", "cough");
        provider.provideUUID(input3);
        String expected = "3";
        String result = provider.findUUID("Test");
        Assertions.assertEquals(expected, result);
    }
}