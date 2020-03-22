package academy.everyonecodes.threepwoodcinema.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateEngineTest {
    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "'Hello test! How about a Friday night movie? This week with a 20% discount!', test",
            "'Good day Mr. test, don''t forget our 20% discount on tickets this Friday!', Mr. test",
            "'Dear Ms. test, you and your friends will have so much fun at the cinema this Friday with a 20% discount!', Ms. test",
            "'My dearest Mr. Threepwood test, your lovely family gives you a 20% discount on tickets this Friday!', Mr. Threepwood test"
    })
    void customiseMessage(String expected, String input) {
        String result = templateEngine.customiseMessage(input);
        Assertions.assertEquals(expected, result);
    }
}