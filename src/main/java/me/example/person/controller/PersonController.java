package me.example.person.controller;

import lombok.RequiredArgsConstructor;
import me.example.person.dao.AddressRepository;
import me.example.person.dao.PersonAddressRepository;
import me.example.person.dao.PersonRepository;
import me.example.person.dto.PersonDto;
import me.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final PersonAddressRepository personAddressRepository;

    // Создание данных о гражданине
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto createdPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    // Получить данные о гражданине
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> getPerson(@PathVariable("id") Long personId) {
        return ResponseEntity.ok(personService.getPersonById(personId));
    }
}
