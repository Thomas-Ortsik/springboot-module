package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SummaryCalculatorTest {
    @Autowired
    SummaryCalculator calculator;
    @Value("${deliveryCost}")
    double deliveryCost;

    ItemSelection inputItem = new ItemSelection("testUser", "testItem", 1.0);
    Optional<User> premiumUser = Optional.of(new User("testUser", "premium account"));
    Optional<User> noAccountUser = Optional.empty();
    Optional<User> standardUser = Optional.of(new User("testUser", "standard account"));

    @Test
    void createSummaryWithPremiumUser() {
        Summary expected = new Summary("testUser", "testItem", 1.0, 0.0, 1.0);
        Summary result = calculator.createSummary(inputItem, premiumUser);
        assertEquals(expected, result);
    }

    @Test
    void createSummaryWithStandardUser() {
        Summary expected = new Summary("testUser", "testItem", 1.0, 1.0, 2.0);
        Summary result = calculator.createSummary(inputItem, standardUser);
        assertEquals(expected, result);
    }
    @Test
    void createSummaryWithNoAccountUser() {
        Summary expected = new Summary("testUser", "testItem", 1.0, 1.0, 2.0);
        Summary result = calculator.createSummary(inputItem, noAccountUser);
        assertEquals(expected, result);
    }


}