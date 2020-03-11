package academy.everyonecodes.calculator.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;
@SpringBootTest
class ExpressionParserTest {
@Autowired
ExpressionParser expressionParser;
    static Stream<Arguments> expressionMaker() {
        return Stream.of(
                Arguments.of("1 * 1", new Expression("*", 1.0, 1.0)),
                Arguments.of("1.0 + 1.0", new Expression("+", 1.0, 1.0)),
                Arguments.of("1.0 / 0.0", new Expression("/", 1.0, 0.0)),
                Arguments.of("-1.0 - -2", new Expression("-", -1.0, -2.0))
        );
    }

    @ParameterizedTest
    @MethodSource("expressionMaker")
    void parse(String input, Expression expected) {
        Expression result = expressionParser.parse(input);
        Assertions.assertEquals(expected, result);
    }
}