package me.example.person.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

// https://www.baeldung.com/jpa-many-to-many#2-implementation-in-jpa
// https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonAddressId implements Serializable {

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "address_id")
    private Long addressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonAddressId that)) return false;
        return Objects.equals(personId, that.personId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, addressId);
    }
}
