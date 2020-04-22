package academy.everyonecodes.phonebook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String street;


    /**********
     test if Max works with strings
     If catastrophic failure: try fixing this first
     ************/
    @Max(10000)
    private String postalCode;

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public Address(String street, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
