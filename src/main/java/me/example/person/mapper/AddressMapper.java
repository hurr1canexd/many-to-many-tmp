package me.example.person.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.example.person.dto.AddressDto;
import me.example.person.entity.Address;

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
