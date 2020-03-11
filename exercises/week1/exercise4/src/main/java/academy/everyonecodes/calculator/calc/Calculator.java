package academy.everyonecodes.calculator.calc;

import academy.everyonecodes.calculator.calc.operations.Calculation;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Calculator {
    private final ExpressionParser expressionParser;
    private final Set<Calculation> calculations;

    public Calculator(ExpressionParser expressionParser, Set<Calculation> calculations) {
        this.expressionParser = expressionParser;
        this.calculations = calculations;
    }

    public double calculate(String expressionAsString) throws IllegalArgumentException {
        Expression expression = expressionParser.parse(expressionAsString);
        if (expression.getSymbol().equals("/") && expression.getTerm2() == 0) {
            throw new IllegalArgumentException("Divide by Zero");
        }
        return calculations.stream()
                .filter(calculation -> calculation.matches(expression.getSymbol()))
                .map(calculation -> calculation.calculate(expression))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
