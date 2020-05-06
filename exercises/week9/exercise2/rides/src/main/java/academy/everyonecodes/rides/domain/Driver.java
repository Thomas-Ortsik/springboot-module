package academy.everyonecodes.rides.domain;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String typeOfCar;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Ride> rides;

    public Driver() {
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", rides=" + rides +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(typeOfCar, driver.typeOfCar) &&
                Objects.equals(rides, driver.rides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, typeOfCar, rides);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
