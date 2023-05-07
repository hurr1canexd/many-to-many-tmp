package me.example.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import me.example.person.domain.PersonAddress;
import me.example.person.domain.PersonAddressId;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, PersonAddressId> {
}
