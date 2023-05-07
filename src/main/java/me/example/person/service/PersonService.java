package me.example.person.service;

import lombok.RequiredArgsConstructor;
import me.example.person.dao.AddressRepository;
import me.example.person.dao.PersonAddressRepository;
import me.example.person.dao.PersonRepository;
import me.example.person.dto.PersonDto;
import me.example.person.entity.Address;
import me.example.person.entity.Person;
import me.example.person.entity.PersonAddress;
import me.example.person.mapper.AddressMapper;
import me.example.person.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final PersonAddressRepository personAddressRepository;

    @Transactional
    public PersonDto createPerson(PersonDto personDto) {
        // save a person
        Person person = PersonMapper.dto2Entity(personDto);
        Person savedPerson = personRepository.save(person);

        // save a registration address
        Address regAddressEntity = AddressMapper.dto2Entity(personDto.getRegistrationAddress());
        Address savedRegistrationAddress = addressRepository.save(regAddressEntity);

        // save the residential addresses
        List<Address> toSaveResidentialAddresses = personDto.getResidentialAddresses().stream()
                .map(AddressMapper::dto2Entity)
                .toList();
        List<Address> savedResidentialAddresses = addressRepository.saveAll(toSaveResidentialAddresses);

        // construct and save the intermediary many-to-many entities
        List<PersonAddress> toSavePersonAddressList = new ArrayList<>();
        toSavePersonAddressList.add(new PersonAddress(savedPerson, savedRegistrationAddress, true));
        toSavePersonAddressList.addAll(savedResidentialAddresses.stream()
                .map(address -> new PersonAddress(savedPerson, address, false))
                .toList());
        List<PersonAddress> savedPersonAddressList = personAddressRepository.saveAll(toSavePersonAddressList);

        // костыль?
        savedPerson.setAddresses(savedPersonAddressList);

        return PersonMapper.entity2Dto(savedPerson);
    }

    @Transactional
    public PersonDto createPersonAlternative(PersonDto personDto) {
        // save a person
        Person person = PersonMapper.dto2Entity(personDto);
        Person savedPerson = personRepository.save(person);

        // save a registration address
        Address regAddressEntity = AddressMapper.dto2Entity(personDto.getRegistrationAddress());
        Address savedRegistrationAddress = addressRepository.save(regAddressEntity);

        // save the residential addresses
        List<Address> toSaveResidentialAddresses = personDto.getResidentialAddresses().stream()
                .map(AddressMapper::dto2Entity)
                .toList();
        List<Address> savedResidentialAddresses = addressRepository.saveAll(toSaveResidentialAddresses);

        // construct and save the intermediary many-to-many entities
        List<PersonAddress> toSavePersonAddressList = new ArrayList<>();
        toSavePersonAddressList.add(new PersonAddress(savedPerson, savedRegistrationAddress, true));
        toSavePersonAddressList.addAll(savedResidentialAddresses.stream()
                .map(address -> new PersonAddress(savedPerson, address, false))
                .toList());
        List<PersonAddress> savedPersonAddressList = personAddressRepository.saveAll(toSavePersonAddressList);

        // todo убрать костыль и сделать нормально
        savedPerson.setAddresses(savedPersonAddressList);

        return PersonMapper.entity2Dto(savedPerson);
    }


    @Transactional
    public PersonDto getPersonById(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper::entity2Dto)
                .orElseThrow(() -> new RuntimeException("person not found"));
    }
}
