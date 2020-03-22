package academy.everyonecodes.restauranttaxer.beans;

import academy.everyonecodes.restauranttaxer.abstractclass.Taxer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeverageTaxer extends Taxer {
    public BeverageTaxer(@Value("${restaurant.beverages.names}") List<String> names, @Value("${restaurant.beverages.tax}") double tax) {
        super(names, tax);
    }
}
