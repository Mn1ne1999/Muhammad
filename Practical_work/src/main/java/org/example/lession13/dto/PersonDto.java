package org.example.lession13.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    private String middleName;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private List<DocumentDto> identityDocuments;
    private List<ContactDto> contacts;
    private List<AddressDto> addresses;
}
