package org.example.lession13.service;

import org.example.lession13.dto.PersonDto;
import org.example.lession13.dto.PersonSummaryDto;
import org.springframework.data.domain.*;

public interface PersonService {
    PersonDto create(PersonDto dto);
    PersonDto update(PersonDto dto);
    PersonDto get(Long id);
    Page<PersonSummaryDto> list(String region, Pageable pageable);
    boolean verify(String name, String passport);
}
