package academy.everyonecodes.rides.configuration;

import academy.everyonecodes.rides.domain.UberUser;
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
import java.util.stream.Collectors;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("user-credentials")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<UberUser> users;

    public void setUsers(List<UberUser> users) {
        this.users = users;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        List<UserDetails> userDetails = users.stream()
                .map(user -> userConverter(user))
                .collect(Collectors.toList());
        return new InMemoryUserDetailsManager(userDetails);
    }

    private UserDetails userConverter(UberUser user){
        return User.withUsername(user.getUsername())
                .password(passwordEncoder().encode(user.getPassword()))
                .authorities(user.getAuthorities())
                .build();
    }
}
