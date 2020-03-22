package academy.everyonecodes.restauranttaxer.beans;

import academy.everyonecodes.restauranttaxer.data.RestaurantDish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeverageTaxerTest {
    @Autowired
    BeverageTaxer beverageTaxer;
    RestaurantDish okDish = new RestaurantDish("soda", 3.4);
    RestaurantDish badDish = new RestaurantDish("shoe", 34.90);

    @Test
    void matches() {
        boolean result = beverageTaxer.matches(okDish);
        assertTrue(result);
    }
    @Test
    void matchesNot(){
        boolean result = beverageTaxer.matches(badDish);
        assertFalse(result);
    }

    @Test
    void tax() {
        double result = beverageTaxer.tax(okDish);
        double expected = 4.08;
        assertEquals(expected, result);
    }

}