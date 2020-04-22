package academy.everyonecodes.couchpotato.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Name is mandatory")

    private String name;

    @Range(min = 1, max = 5)
    /*
    alternatively probably
    @Min(1)
    @Max(5)
     */
    private int rating;

    public Film(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return rating == film.rating &&
                Objects.equals(id, film.id) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }
}
