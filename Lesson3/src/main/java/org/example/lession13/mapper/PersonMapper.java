package org.example.lession13.mapper;


import org.example.lession13.dto.PersonDto;
import org.example.lession13.dto.PersonSummaryDto;
import org.example.lession13.model.Person;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = { DocumentMapper.class, ContactMapper.class, AddressMapper.class }
)
public interface PersonMapper {
    Person toEntity(PersonDto dto);
    PersonDto toDto(Person entity);

    @Mapping(target = "fullName", expression = "java(entity.getLastName() + \" \" + entity.getFirstName() + \" \" + entity.getMiddleName())")
    PersonSummaryDto toSummaryDto(Person entity);

    void updateEntity(@MappingTarget Person target, PersonDto source);
}