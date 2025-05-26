package org.example.lession13.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSummaryDto {
    private Long id;
    private String fullName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String phone;
    private String mainDocument;
    private String registrationAddress;
}