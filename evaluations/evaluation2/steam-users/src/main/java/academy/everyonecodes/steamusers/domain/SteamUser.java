package academy.everyonecodes.steamusers.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;
import java.util.Set;

public class SteamUser {

    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private Set<String> authorities;

    public SteamUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SteamUser{" +
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
        SteamUser steamUser = (SteamUser) o;
        return Objects.equals(id, steamUser.id) &&
                Objects.equals(username, steamUser.username) &&
                Objects.equals(password, steamUser.password) &&
                Objects.equals(authorities, steamUser.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }

    public SteamUser(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
