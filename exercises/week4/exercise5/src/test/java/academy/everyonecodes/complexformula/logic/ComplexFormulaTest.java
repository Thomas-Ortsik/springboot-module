package academy.everyonecodes.complexformula.logic;

import academy.everyonecodes.complexformula.client.FormulaClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ComplexFormulaTest {
    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient client;

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "2,1,1",
            "1010, 55, 5",
            "18181818, 9999, 9"
    })
    void complexFormulaCalculation(int expected, int input, int inputDigit) {
        Mockito.when(client.getFormulaResult(inputDigit)).thenReturn(inputDigit*2);
        int result = complexFormula.complexFormulaCalculation(input);
        Assertions.assertEquals(expected, result);
        Mockito.verify(client, Mockito.atLeastOnce()).getFormulaResult(inputDigit);
    }
}