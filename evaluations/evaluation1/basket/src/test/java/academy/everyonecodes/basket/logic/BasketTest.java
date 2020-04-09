package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import com.jayway.jsonpath.internal.function.numeric.Sum;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BasketTest {
    @Autowired
    Basket basket;
    @MockBean
    SummaryCalculator calculator;
    @MockBean
    UsersClient client;

    ItemSelection input = new ItemSelection("test1", "test", 1.0);
    Optional<User> testUser = Optional.of(new User("test1", "test"));
    Summary testSummary = new Summary("test1", "test", 1.0, 1.5, 2.5);

    @Test
    @Order(1)
    void getEmptySummaries(){
        List<Summary> expected = List.of();
        List<Summary> result = basket.getSummaries();
        assertEquals(expected, result);
    }
    @Test
    @Order(2)
    void addToEmptyBasket() {
        Mockito.when(client.getAccount(input.getUserEmail())).thenReturn(testUser);
        Mockito.when(calculator.createSummary(input, testUser)).thenReturn(testSummary);
        basket.addToBasket(input);
        Mockito.verify(client).getAccount("test1");
        Mockito.verify(calculator).createSummary(input, testUser);
    }

    @Test
    @Order(3)
    void getSummaries() {
        List<Summary> expected = List.of(testSummary);
        List<Summary> result = basket.getSummaries();
        assertEquals(expected, result);
    }
}