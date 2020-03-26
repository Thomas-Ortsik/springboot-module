package academy.everyonecodes.fleamarket.logic;

import academy.everyonecodes.fleamarket.domain.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemStorage {
    private List<Item> items;

    public ItemStorage() {
        this.items = new ArrayList<>();
    }

    public List<Item> findItems(String name){
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Item> getAll(){
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }
}
