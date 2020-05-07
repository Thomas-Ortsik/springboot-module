package academy.everyonecodes.steampurchases.endpoint;

import academy.everyonecodes.steampurchases.domain.Game;
import academy.everyonecodes.steampurchases.domain.Purchase;
import academy.everyonecodes.steampurchases.domain.User;
import academy.everyonecodes.steampurchases.logic.PurchasesService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PurchasesEndpoint {
    private final PurchasesService service;

    public PurchasesEndpoint(PurchasesService service) {
        this.service = service;
    }

    @PostMapping("purchases")
    @Secured("ROLE_APP")
    Purchase post(@RequestBody Purchase purchase){
        return service.savePurchase(purchase);
    }

    @GetMapping("users")
    @Secured("ROLE_ADMIN")
    List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("games")
    List<Game> getGames(){
        return service.getGames();
    }


}
