package academy.everyonecodes.drhouseaccountancy.domain;

import java.util.List;

public class Accountant {
    private String username;
    private String password;
    private String[] authorities;

    public Accountant() {
    }

    public Accountant(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }
}
