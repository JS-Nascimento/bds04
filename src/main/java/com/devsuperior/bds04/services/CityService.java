package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public CityService(CityRepository repository) {
        this.repository = repository;

    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> cityList = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        return cityList.stream().map(city -> modelMapper.map(city, CityDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public CityDTO create(CityDTO dto) {
        City City = repository.save(modelMapper.map(dto, City.class));
        return modelMapper.map(City, CityDTO.class);
    }


}
