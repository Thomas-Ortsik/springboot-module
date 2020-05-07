package academy.everyonecodes.steampurchases.logic;

import academy.everyonecodes.steampurchases.domain.Game;
import academy.everyonecodes.steampurchases.domain.Purchase;
import academy.everyonecodes.steampurchases.domain.User;
import academy.everyonecodes.steampurchases.repo.GameRepository;
import academy.everyonecodes.steampurchases.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PurchasesService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public PurchasesService(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public Purchase savePurchase(Purchase purchase) {
        Game game = new Game(purchase.getUuid(), purchase.getName(), purchase.getPrice());
        gameRepository.save(game);
        User user;
        Optional<User> oUser = userRepository.findByUsername(purchase.getUsername());
        if (oUser.isEmpty()) {
            user = createNewUser(purchase.getUsername());
        } else {
            user = oUser.get();
        }
        user.getGames().add(game);
        userRepository.save(user);
        return purchase;
    }

    private User createNewUser(String username) {
        User user = new User(username, new LinkedHashSet<>());
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<Game> getGames(){
        return gameRepository.findAll();
    }
}
