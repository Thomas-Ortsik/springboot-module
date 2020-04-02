package academy.everyonecodes.complexformula.logic;

import academy.everyonecodes.complexformula.client.FormulaClient;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ComplexFormula {
    private final FormulaClient client;

    public ComplexFormula(FormulaClient client) {
        this.client = client;
    }



    public int complexFormulaCalculation(int number){
        String[] numberAsString = String.valueOf(number).split("");
        //Clean Codes Everyone, Get your Clean Codes!
        return Integer.parseInt(Stream.of(numberAsString)
                .map(num -> String.valueOf(client.getFormulaResult(Integer.valueOf(num))))
                .collect(Collectors.joining()));
    }
}
