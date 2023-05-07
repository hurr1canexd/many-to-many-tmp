package me.example.person.mapper;

import me.example.person.domain.Address;
import me.example.person.domain.Region;
import me.example.person.dto.AddressDto;

public class AddressMapper {

    private AddressMapper() {}

    public static Address dto2Entity(AddressDto dto) {
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setValue(dto.getValue());
//        entity.setRegion(new Region(dto.getRegionName()));

        return entity;
    }

    public static AddressDto entity2Dto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
//        dto.setRegionName(entity.getRegion().getName());

        return dto;
    }
}
