package com.oddle.app.services.impl;

import com.oddle.app.models.entities.CityModel;
import com.oddle.app.models.repositories.CityRepository;
import com.oddle.app.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityModel insert(CityModel data) {
        CityModel city = cityRepository.findByNameAndCountryCode(data.getName(), data.getCountryCode());
        return Objects.isNull(city) ? cityRepository.save(data) : city;
    }
}
