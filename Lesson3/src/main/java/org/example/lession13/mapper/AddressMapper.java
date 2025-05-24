package org.example.lession13.mapper;

import org.example.lession13.dto.AddressDto;
import org.example.lession13.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;



@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AddressMapper {
    AddressDto toDto(Address entity);

    @Mapping(target = "residents", ignore = true)
    Address toEntity(AddressDto dto);
}