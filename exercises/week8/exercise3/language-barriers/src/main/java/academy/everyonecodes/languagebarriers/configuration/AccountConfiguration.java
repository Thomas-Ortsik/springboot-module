package academy.everyonecodes.languagebarriers.configuration;

import academy.everyonecodes.languagebarriers.domain.Account;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties("users")
public class AccountConfiguration {
    private List<Account> accounts;

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Bean
    List<UserDetails> users(PasswordEncoder encoder) {
        return accounts.stream()
                .map(account -> User.withUsername(account.getUsername())
                        .password(encoder.encode(account.getPassword()))
                        .authorities(account.getAuthorities().toArray(new String[account.getAuthorities().size()]))
                        .build())
                .collect(Collectors.toList());
    }
}
