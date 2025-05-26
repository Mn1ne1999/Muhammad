package org.example.lession13.mapper;

import org.example.lession13.dto.DocumentDto;
import org.example.lession13.model.IdentityDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.w3c.dom.Document;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DocumentMapper {
    DocumentDto toDto(IdentityDocument entity);
    IdentityDocument toEntity(DocumentDto dto);
}
