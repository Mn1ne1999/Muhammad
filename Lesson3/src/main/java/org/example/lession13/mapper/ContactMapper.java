package org.example.lession13.mapper;

import org.example.lession13.dto.ContactDto;
import org.example.lession13.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ContactMapper {
    ContactDto toDto(Contact entity);
    Contact toEntity(ContactDto dto);
}
