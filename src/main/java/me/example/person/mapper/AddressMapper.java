package me.example.person.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.example.person.domain.Address;
import me.example.person.dto.AddressDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {

    public static Address dto2Entity(AddressDto dto) {
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setValue(dto.getValue());

        return entity;
    }

    public static AddressDto entity2Dto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());

        return dto;
    }
}
