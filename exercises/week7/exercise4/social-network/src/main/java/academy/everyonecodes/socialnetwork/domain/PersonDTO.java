package academy.everyonecodes.socialnetwork.domain;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDTO {

    private Long id;
    @NotEmpty
    private String name;
    private List<String> friendNames;

    public PersonDTO(Long id, String name, List<String> friendNames) {
        this.id = id;
        this.name = name;
        this.friendNames = friendNames;
    }

    public PersonDTO(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) &&
                Objects.equals(name, personDTO.name) &&
                Objects.equals(friendNames, personDTO.friendNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, friendNames);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriendNames() {
        return friendNames;
    }

    public void setFriendNames(List<String> friendNames) {
        this.friendNames = friendNames;
    }
}
