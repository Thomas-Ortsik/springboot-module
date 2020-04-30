package academy.everyonecodes.languagebarriers.domain;

import java.util.Set;

public class Account {
    private String username;
    private String password;
    private Set<String> authorities;

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

    public Set<String> getAuthorities() {
        return authorities;
    }

    void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
