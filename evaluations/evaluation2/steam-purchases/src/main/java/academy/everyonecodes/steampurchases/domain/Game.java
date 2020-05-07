package academy.everyonecodes.steampurchases.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.price, price) == 0 &&
                Objects.equals(id, game.id) &&
                Objects.equals(uuid, game.uuid) &&
                Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, name, price);
    }

    @Column(unique = true)
    private String uuid;
    private String name;
    private double price;

    public Game(String uuid, String name, double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public Game() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
