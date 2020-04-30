package academy.everyonecodes.thehotelroom.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConfigurationProperties("usercredentials")
public class Customer {
    private String username;
    private String password;
    private String authorities;

    public String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
