package academy.everyonecodes.steamusers.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;
import java.util.Set;

@Configuration
@ConfigurationProperties("steam-app")
public class SteamAppUser {
    private String id;
    private String username;
    private String password;
    private Set<String> authorities;

    @Override
    public String toString() {
        return "SteamAppUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamAppUser that = (SteamAppUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }

    public SteamUser addAdmin() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return new SteamUser(username, encoder.encode(password), authorities);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
