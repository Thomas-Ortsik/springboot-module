package academy.everyonecodes.threepwoodcinema.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TemplateMessageFinderTest {
@Autowired
TemplateMessageFinder templateMessageFinder;
    @ParameterizedTest
    @CsvSource({
            "'Hello %s! How about a Friday night movie? This week with a 20% discount!', test",
            "'Good day %s, don''t forget our 20% discount on tickets this Friday!', Mr. test",
            "'Dear %s, you and your friends will have so much fun at the cinema this Friday with a 20% discount!', Ms. test",
            "'My dearest %s, your lovely family gives you a 20% discount on tickets this Friday!', Threepwood test"
    })
    void find(String expected, String input) {
        String result = templateMessageFinder.find(input);
        Assertions.assertEquals(expected,result);

    }
}