package org.example.lession13.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import org.example.lession13.model.DocumentType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private Long id;
    private DocumentType type;
    private String number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;
    private String issuedBy;
}