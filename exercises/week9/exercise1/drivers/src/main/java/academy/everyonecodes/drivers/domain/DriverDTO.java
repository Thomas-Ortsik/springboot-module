package academy.everyonecodes.drivers.domain;

import java.util.Objects;
import java.util.Set;

public class DriverDTO {
    private String id;
    private String username;
    private String password;
    private String typeOfCar;
    private boolean available;
    private Set<String> authorities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public DriverDTO(String username, String password, String typeOfCar) {
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", available=" + available +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverDTO driverDTO = (DriverDTO) o;
        return available == driverDTO.available &&
                Objects.equals(id, driverDTO.id) &&
                Objects.equals(username, driverDTO.username) &&
                Objects.equals(password, driverDTO.password) &&
                Objects.equals(typeOfCar, driverDTO.typeOfCar) &&
                Objects.equals(authorities, driverDTO.authorities);
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

    public DriverDTO(String id, String username, String password, String typeOfCar, boolean available, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.available = available;
        this.authorities = authorities;
    }
}
