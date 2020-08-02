package com.oddle.app.models.repositories;

import com.oddle.app.models.entities.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository  extends JpaRepository<CityModel, String> {
    CityModel findByNameAndCountryCode(String name, String countryCode);
}
