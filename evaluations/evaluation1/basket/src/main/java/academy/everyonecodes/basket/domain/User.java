package academy.everyonecodes.basket.domain;

import java.util.Objects;

public class User {
    private String userEmail;
    private String accountType;

    User() {
    }

    public User(String userEmail, String accountType) {
        this.userEmail = userEmail;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(accountType, user.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, accountType);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
