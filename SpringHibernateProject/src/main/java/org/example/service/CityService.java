package org.example.service;

import org.example.entity.City;
import org.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public void deleteCity(Long id) {
        cityRepository.delete(id);
    }
}
