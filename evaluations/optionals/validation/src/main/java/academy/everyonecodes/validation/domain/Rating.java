package academy.everyonecodes.validation.domain;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;
@Validated
public class Rating {
    @Override
    public String toString() {
        return "Rating{" +
                "stars=" + stars +
                '}';
    }

    @Min(1)
    @Max(5)
    private int stars;

    public Rating(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return stars == rating.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
