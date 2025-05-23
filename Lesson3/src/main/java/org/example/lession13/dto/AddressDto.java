package org.example.lession13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
    private boolean registration;
}