package academy.everyonecodes.cc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IssuerTest {
    Issuer issuer = new Issuer();

    static Stream<Arguments> issuerMaker(){
        return Stream.of(
                Arguments.of(true, new Issuer("test", Set.of("34", "37"), Set.of(2, 6)), "370000"),
                Arguments.of(false, new Issuer("test", Set.of("34", "37"), Set.of(2, 6)), "39"),
                Arguments.of(false, new Issuer("test", Set.of(), Set.of(2, 6)), "370000"),
                Arguments.of(false, new Issuer("test", Set.of("34", "37"), Set.of()), "370000"),
                Arguments.of(true, new Issuer("test", Set.of("1"), Set.of(1)), "1")
        );
    }

    @Test
    void getName() {
        String expected = "test";
        Issuer issuer = new Issuer("test", Set.of(), Set.of());
        String result = issuer.getName();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("issuerMaker")
    void issues(boolean expected, Issuer issuer, String input) {
        boolean result = issuer.issues(input);
        assertEquals(expected, result);
    }
}