package academy.everyonecodes.basket.config;

import academy.everyonecodes.basket.client.UsersClient;
import academy.everyonecodes.basket.logic.Basket;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasketConfiguration {

    //no idea why I'm doing this, except because it's in the description
    //so please enlighten me after the evaluation ;)

    private final SummaryCalculator summaryCalculator;
    private final UsersClient client;

    public BasketConfiguration(SummaryCalculator summaryCalculator, UsersClient client) {
        this.summaryCalculator = summaryCalculator;
        this.client = client;
    }

    @Bean
    Basket basket(){
        return new Basket(summaryCalculator, client);
    }
}
