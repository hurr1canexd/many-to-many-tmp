package me.example.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import me.example.person.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
