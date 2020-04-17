package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.domain.Patient;
import academy.everyonecodes.drhousetreatments.domain.Treatment;
import academy.everyonecodes.drhousetreatments.repo.TreatmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TreatmentServiceTest {
    @Autowired
    TreatmentService service;
    @MockBean
    TreatmentRepository repository;
    //I'm just gonna test the nurse here as well
    @Autowired
    Nurse nurse;

    Patient input = new Patient("uuid", "name", "symptoms","diagnosis", null);
    Patient expected = new Patient("uuid", "name", "symptoms", "diagnosis", "spend one day in the hospital bed");
    Treatment expectedInputTreatment = new Treatment("uuid", "name", "symptoms", "diagnosis", "spend one day in the hospital bed");

    @Test
    void postTreatment() {
        Patient result = service.postTreatment(input);
        Mockito.verify(repository).save(expectedInputTreatment);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getTreatments() {
        service.getTreatments();
        Mockito.verify(repository).findAll();
    }

    @Test
    void getSpecificTreatments() {
        service.getSpecificTreatments("test");
        Mockito.verify(repository).findByUuid("test");
    }
}