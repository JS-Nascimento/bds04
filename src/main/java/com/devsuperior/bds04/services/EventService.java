package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    private final EventRepository repository;

    private final CityRepository cityRepository;

    public EventService(EventRepository repository, CityRepository cityRepository) {
        this.repository = repository;
        this.cityRepository = cityRepository;
    }


    @Transactional(readOnly = true)
    public Page<EventDTO> findAllPaged(Pageable pageable) {
        Page<Event> list = repository.findAll(pageable);
        return list.map(Event -> (new EventDTO(Event)));
    }


    @Transactional
    public EventDTO create(EventDTO dto) {
        Event Event = new Event();
        repository.save(mapperToEntity(dto, Event));
        return new EventDTO(Event);
    }


    private Event mapperToEntity(EventDTO dto, Event entity) {

        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(cityRepository.getReferenceById(dto.getCityId()));
        return entity;
    }
}
