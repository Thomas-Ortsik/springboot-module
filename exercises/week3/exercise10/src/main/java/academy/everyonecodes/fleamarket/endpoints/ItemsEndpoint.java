package academy.everyonecodes.fleamarket.endpoints;

import academy.everyonecodes.fleamarket.domain.Item;
import academy.everyonecodes.fleamarket.logic.ItemStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsEndpoint {
    private ItemStorage itemStorage;


    public ItemsEndpoint(ItemStorage itemStorage) {
        this.itemStorage = itemStorage;
    }

    @GetMapping
    List<Item> getAll(){
        return itemStorage.getAll();
    }

    @GetMapping("/{name}")
    List<Item> getSpecificItems(@PathVariable String name){
        return itemStorage.findItems(name);
    }

    @PostMapping
    Item postItem(@RequestBody Item item){
        itemStorage.addItem(item);
        return item;
    }
}
