package academy.everyonecodes.drhousediagnoses.logic;

import academy.everyonecodes.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosisRoomTest {
@Autowired
DiagnosisRoom diagnosisRoom;
@MockBean
DrHouse drHouse;
    @Test
    void diagnose() {
        Patient input = new Patient("testUUID", "TestName", "testSymptoms", null);
        Patient expected = new Patient("testUUID", "TestName", "testSymptoms", "testDiagnosis");
        Mockito.when(drHouse.diagnose(input)).thenReturn(expected);
        Patient result = diagnosisRoom.diagnose(input);
        Mockito.verify(drHouse).diagnose(input);
        Assertions.assertEquals(expected, result);
    }
}