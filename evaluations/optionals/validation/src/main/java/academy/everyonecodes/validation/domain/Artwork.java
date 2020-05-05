package academy.everyonecodes.validation.domain;

import javax.validation.Valid;

public class Artwork {
    private String name;
    @Valid
    private Rating rating;

    public Artwork(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
