package me.example.person.dao;

import me.example.person.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CustomRepository<Person, Long> {
}