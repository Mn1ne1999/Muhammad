package org.example.lession13.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lession13.dto.PersonDto;
import org.example.lession13.dto.PersonSummaryDto;
import org.example.lession13.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService service;

    @PostMapping
    public PersonDto create(@Valid @RequestBody PersonDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public PersonDto update(@Valid @RequestBody PersonDto dto) {
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public PersonDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public Page<PersonSummaryDto> list(@RequestParam(required = false) String region,
                                       @PageableDefault Pageable pageable) {
        return service.list(region, pageable);
    }

    @GetMapping("/verify")
    public boolean verify(@RequestParam String name, @RequestParam String passport) {
        return service.verify(name, passport);
    }
}