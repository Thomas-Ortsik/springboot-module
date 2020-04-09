package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Basket {
    private final SummaryCalculator summaryCalculator;
    private final UsersClient client;
    private List<Summary> summaries = new ArrayList<>();

    public Basket(SummaryCalculator summaryCalculator, UsersClient client) {
        this.summaryCalculator = summaryCalculator;
        this.client = client;
    }

    public ItemSelection addToBasket(ItemSelection item){
        Optional<User> oUser = client.getAccount(item.getUserEmail());
        summaries.add(summaryCalculator.createSummary(item, oUser));
        return item;
    }

    public List<Summary> getSummaries(){
        return summaries;
    }
}
