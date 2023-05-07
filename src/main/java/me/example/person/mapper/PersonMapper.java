package me.example.person.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.example.person.domain.Person;
import me.example.person.domain.PersonAddress;
import me.example.person.dto.AddressDto;
import me.example.person.dto.PersonDto;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapper {

    public static Person dto2Entity(PersonDto dto) {
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDate(dto.getBirthDate());

        return entity;
    }

    public static PersonDto entity2Dto(Person entity) {
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDate(entity.getBirthDate());

        if (entity.getAddresses() != null) {
            Optional<PersonAddress> first = entity.getAddresses()
                    .stream()
                    .filter(PersonAddress::isRegistration)
                    .findFirst();
            first.ifPresent(personAddress ->
                    dto.setRegistrationAddress(AddressMapper.entity2Dto(personAddress.getAddress())));

            List<AddressDto> residentialAddresses = entity.getAddresses()
                    .stream()
                    .filter(personAddress -> !personAddress.isRegistration())
                    .map(personAddress -> AddressMapper.entity2Dto(personAddress.getAddress())).toList();
            dto.setResidentialAddresses(residentialAddresses);
        }

        return dto;
    }
}
