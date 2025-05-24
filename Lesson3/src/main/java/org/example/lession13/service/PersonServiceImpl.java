package org.example.lession13.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lession13.dto.PersonDto;
import org.example.lession13.dto.PersonSummaryDto;
import org.example.lession13.exception.EntityNotFoundException;
import org.example.lession13.mapper.PersonMapper;
import org.example.lession13.model.Person;
import org.example.lession13.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Override
    @Transactional
    public PersonDto create(PersonDto dto) {
        log.info("CREATE DTO = {}", dto);

        // 1) Создаём entity вручную
        Person p = new Person();
        p.setLastName( dto.getLastName() );
        p.setFirstName( dto.getFirstName() );
        p.setMiddleName( dto.getMiddleName() );
        p.setBirthDate( dto.getBirthDate() );
        // (Для начала пропустим identityDocuments, contacts, addresses)

        // 2) Сохраняем
        Person saved = repository.save(p);

        // 3) Маппим обратно в DTO вручную
        PersonDto result = new PersonDto();
        result.setId( saved.getId() );
        result.setLastName( saved.getLastName() );
        result.setFirstName( saved.getFirstName() );
        result.setMiddleName( saved.getMiddleName() );
        result.setBirthDate( saved.getBirthDate() );
        // и (если нужно) identityDocuments, contacts, addresses — пока опустим

        log.info("CREATED DTO = {}", result);
        return result;
    }


    @Override
    @Transactional
    public PersonDto update(PersonDto dto) {
        // Здесь исправлено dto.id() → dto.getId()
        Person existing = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        mapper.updateEntity(existing, dto);
        Person updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDto get(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }


    @Override
    @Transactional(readOnly = true)
    public Page<PersonSummaryDto> list(String region, Pageable pageable) {
        return repository.findPage(region, pageable)
                .map(mapper::toSummaryDto);
    }

    @Override
    public boolean verify(String name, String passport) {
        return repository.verifyNameAndPassport(name, passport);
    }
}
