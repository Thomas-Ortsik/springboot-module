package academy.everyonecodes.drivers.domain;

import java.util.Objects;
import java.util.Set;

public class Driver {
    private String id;
    private String username;
    private String password;
    private String typeOfCar;
    private boolean available;
    private Set<String> authorities;

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", available=" + available +
                ", authorities=" + authorities +
                '}';
    }

    public Driver(String username, String password, String typeOfCar) {
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return available == driver.available &&
                Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(typeOfCar, driver.typeOfCar) &&
                Objects.equals(authorities, driver.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, typeOfCar, available, authorities);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Driver(String id, String username, String password, String typeOfCar, boolean available, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.available = available;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
