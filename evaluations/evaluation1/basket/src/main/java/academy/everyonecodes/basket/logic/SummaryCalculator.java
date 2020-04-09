package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SummaryCalculator {
    @Value ("${deliveryCost}")
    private double deliveryCost;

    //I call it create, because we don't just calculate, but create a Summary object
    public Summary createSummary(ItemSelection item, Optional<User> oUser){
        double itemPrice = item.getItemPrice();
        double deliveryCost = deliveryCost(oUser);
        return new Summary(
                item.getUserEmail(),
                item.getItemName(),
                itemPrice,
                deliveryCost,
                itemPrice+deliveryCost
        );
    }

    private double deliveryCost(Optional<User> oUser){
        if (oUser.isPresent() && oUser.get().getAccountType().equals("premium account")){
            return 0.00;
        }
        return deliveryCost;
    }

}
