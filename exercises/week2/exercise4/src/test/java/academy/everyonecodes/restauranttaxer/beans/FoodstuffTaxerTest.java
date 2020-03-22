package academy.everyonecodes.restauranttaxer.beans;

import academy.everyonecodes.restauranttaxer.data.RestaurantDish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodstuffTaxerTest {
    @Autowired
    FoodstuffTaxer foodstuffTaxer;
    RestaurantDish okDish = new RestaurantDish("tiramisu", 3.4);
    RestaurantDish badDish = new RestaurantDish("shoe", 34.90);

    @Test
    void matches() {
        boolean result = foodstuffTaxer.matches(okDish);
        assertTrue(result);
    }
    @Test
    void matchesNot(){
        boolean result = foodstuffTaxer.matches(badDish);
        assertFalse(result);
    }

@Test
    void tax() {
        double result = foodstuffTaxer.tax(okDish);
        double expected = 3.74;
        assertEquals(expected, result);
    }
}