package academy.everyonecodes.sah.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
class HandsakeNumberToMoveTranslatorTest {
    @Autowired
    HandsakeNumberToMoveTranslator translator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.of("thumb touches back"), 2),
                Arguments.of(Optional.of("thousand knuckles"), 9),
                Arguments.of(Optional.of("bro knuckles"), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(Optional<String> oExpected, int input) {
        Optional<String> oResult = translator.translate(input);
        Assertions.assertTrue(oExpected.isPresent());
        Assertions.assertTrue(oResult.isPresent());
        Assertions.assertEquals(oExpected.get(), oResult.get());
    }

    @Test
    void transl() {
        int input = 0;
        Optional<String> result = translator.translate(input);
        Assertions.assertTrue(result.isEmpty());
    }
}