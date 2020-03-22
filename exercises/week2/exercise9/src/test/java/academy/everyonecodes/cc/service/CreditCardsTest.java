package academy.everyonecodes.cc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;
@SpringBootTest
class CreditCardsTest {
    @Autowired
    CreditCards creditCards;

    static Stream<Arguments> creditGiver() {
        return Stream.of(
                Arguments.of("Invalid", "1111111111"),
                Arguments.of("Not Supported", "3530111333300000"),
                Arguments.of("Visa", "4012888888881881"),
                Arguments.of("Discover", "6011111111111117"),
                Arguments.of("American Express", "378282246310005"),
                Arguments.of("MasterCard", "5555555555554444")
        );
    }

    @ParameterizedTest
    @MethodSource("creditGiver")
    void inspect(String expected, String input) {
        String result = creditCards.inspect(input);
        Assertions.assertEquals(expected, result);
    }
}