package me.example.person.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON_ADDRESS")
@NoArgsConstructor
@Getter
@Setter
public class PersonAddress {

    @EmbeddedId
    private PersonAddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    private Address address;

    private boolean registration;

    public PersonAddress(Person person,
                         Address address,
                         boolean registration) {
        this.person = person;
        this.address = address;
        this.registration = registration;
        this.id = new PersonAddressId(person.getId(), address.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonAddress that)) return false;
        return Objects.equals(person, that.person) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, address);
    }
}
