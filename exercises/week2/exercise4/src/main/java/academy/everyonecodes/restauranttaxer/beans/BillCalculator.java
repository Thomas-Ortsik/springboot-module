package academy.everyonecodes.restauranttaxer.beans;

import academy.everyonecodes.restauranttaxer.abstractclass.Taxer;
import academy.everyonecodes.restauranttaxer.data.RestaurantDish;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillCalculator {
    private final Set<Taxer> taxers;

    public BillCalculator(Set<Taxer> taxers) {
        this.taxers = taxers;
    }

    public double calculate(List<RestaurantDish> orderedDishes) {
        return orderedDishes.stream()
                .mapToDouble(this::dishPrice)
                .sum();
    }

    private double dishPrice(RestaurantDish orderedDish) {
        return taxers.stream()
                .filter(taxer -> taxer.matches(orderedDish))
                .map(taxer -> taxer.tax(orderedDish))
                .findFirst().orElse(0.0);  //if it's not in the menu, I guess it's free.
    }
}
