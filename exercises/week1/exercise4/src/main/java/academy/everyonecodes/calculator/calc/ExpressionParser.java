package academy.everyonecodes.calculator.calc;

import org.springframework.stereotype.Service;

@Service
public class ExpressionParser {
    public Expression parse(String expressionAsString) {
        String[] expressionSplit = expressionAsString.split(" ");
        return new Expression(expressionSplit[1], Double.parseDouble(expressionSplit[0]), Double.parseDouble(expressionSplit[2]));
    }
}
