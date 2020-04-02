package academy.everyonecodes.complexformula.endpoints;

import academy.everyonecodes.complexformula.logic.ComplexFormula;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexFormulaEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ComplexFormula complexFormula;

    @Test
    void get() {
        int input = 5;
        String url = "/complexformula/5";
        restTemplate.getForObject(url, int.class);
        Mockito.verify(complexFormula).complexFormulaCalculation(input);
    }
}