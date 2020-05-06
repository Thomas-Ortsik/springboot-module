package academy.everyonecodes.rides.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Long id;

    private String usernameCustomer;
    private int distance;
    private double price;

    public Ride() {
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", usernameCustomer='" + usernameCustomer + '\'' +
                ", distance=" + distance +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return distance == ride.distance &&
                Double.compare(ride.price, price) == 0 &&
                Objects.equals(id, ride.id) &&
                Objects.equals(usernameCustomer, ride.usernameCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usernameCustomer, distance, price);
    }

    public Long getId() {
        return id;
    }

    public String getUsernameCustomer() {
        return usernameCustomer;
    }

    public void setUsernameCustomer(String usernameCustomer) {
        this.usernameCustomer = usernameCustomer;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
