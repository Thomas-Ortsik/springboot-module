package academy.everyonecodes.restauranttaxer.beans;

import academy.everyonecodes.restauranttaxer.data.RestaurantDish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BillCalculatorTest {
@Autowired
BillCalculator billCalculator;

    @Test
    void calculate() {
        List<RestaurantDish> input = List.of(
                new RestaurantDish("soda", 3.4),
                new RestaurantDish("shoe", 34.90),
                new RestaurantDish("potato soup", 3.4),
                new RestaurantDish("tiramisu", 1.0));
        double result = billCalculator.calculate(input);
        double expected = 8.92;
        Assertions.assertEquals(expected, result);
    }
}