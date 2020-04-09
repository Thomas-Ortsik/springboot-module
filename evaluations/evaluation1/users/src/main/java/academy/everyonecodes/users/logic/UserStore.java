package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("users")
public class UserStore {
    private List<User> accounts;

    void setAccounts(ArrayList<User> accounts) {
        this.accounts = accounts;
    }

    List<User> getAllAccounts(){
        return accounts;
    }

    public void addAccount(User user){
        accounts.add(user);
    }

    public Optional<User> getAccountByEmail(String email){
        return accounts.stream()
        .filter(account -> account.getEmail().equals(email))
        .findFirst();
    }
}
