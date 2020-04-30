package academy.everyonecodes.mysterioussecretorder.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("founder")
public class Founder{
    private String username;
    private String password;
    private String authorities;

//ok, this whole class is probably dirty, especially what I'm doing now. I just want to get it running. Tired
    public Member foundOrder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return new Member(username, encoder.encode(password), authorities);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
