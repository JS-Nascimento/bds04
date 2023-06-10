package com.devsuperior.bds04.controllers;


import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAll(Pageable pageable) {
        Page<EventDTO> list = service.findAllPaged(pageable);
        return ResponseEntity
                .ok()
                .body(list);
    }

    @PostMapping
    public ResponseEntity<EventDTO> create(@Valid @RequestBody EventDTO dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}