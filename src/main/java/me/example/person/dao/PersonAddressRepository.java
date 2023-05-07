package me.example.person.dao;

import me.example.person.entity.PersonAddress;
import me.example.person.entity.PersonAddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, PersonAddressId> {
}
