package academy.everyonecodes.steampurchases.configuration;

import academy.everyonecodes.steampurchases.domain.Account;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("user-credentials")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private List<Account> users;

    void setUsers(List<Account> users) {
        this.users = users;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/games").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(users.stream()
                .map(createUserDetails(encoder))
                .collect(Collectors.toList()));
    }


    private Function<Account, UserDetails> createUserDetails(PasswordEncoder encoder) {
        return user -> User.withUsername(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .authorities(user.getAuthorities())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
