package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdmissionTest {
    @Autowired
    Admission admission;

    @Test
    void admit() {
        Patient input = new Patient("", "Test", "cough");
        Patient result = admission.admit(input);
        Patient expected = new Patient("1", "Test", "cough");
        Assertions.assertEquals(expected, result);
    }
}