package academy.everyonecodes.recommendations.domain;

import java.util.Objects;

public class Movie {
    private String title;
    private String properties;

    Movie() {
    }

    public Movie(String title, String properties) {
        this.title = title;
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(properties, movie.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, properties);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
