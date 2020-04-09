package academy.everyonecodes.basket.endpoint;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.Basket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {
    private final Basket basket;

    public ItemSelectionEndpoint(Basket basket) {
        this.basket = basket;
    }

    @PostMapping
    ItemSelection post(@RequestBody ItemSelection item){
        basket.addToBasket(item);
        return item;
    }
}
