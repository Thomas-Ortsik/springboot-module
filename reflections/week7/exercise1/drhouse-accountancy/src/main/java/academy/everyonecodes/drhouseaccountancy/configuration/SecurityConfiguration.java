package academy.everyonecodes.drhouseaccountancy.configuration;

import academy.everyonecodes.drhouseaccountancy.domain.Accountant;
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
@ConfigurationProperties("authorized-users")
//do we really need the GlobalMethodSecurity? At least this one works without
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<Accountant> accountants;

    void setAccountants(List<Accountant> accountants){
        this.accountants = accountants;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/patients").permitAll()
                .anyRequest().hasRole("ACCOUNTANT")
                .and()
                .httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        List<UserDetails> users = accountants.stream()
                .map(toUserDetails(passwordEncoder))
                .collect(Collectors.toList());
        return new InMemoryUserDetailsManager(users);
    }

    private Function<Accountant, UserDetails> toUserDetails(PasswordEncoder encoder){
        return accountant -> User.withUsername(accountant.getUsername())
                .password(encoder.encode(accountant.getPassword()))
                .authorities(accountant.getAuthorities())
                .build();
    }
}
