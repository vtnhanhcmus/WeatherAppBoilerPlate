package com.oddle.app.models.repositories;

import com.oddle.app.models.entities.CityModel;
import com.oddle.app.models.entities.WeatherModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WeatherRepository extends PagingAndSortingRepository<WeatherModel, Long> {
    @Query(value = "select weather from WeatherModel weather where  weather.city = :city group by weather.city, weather.id order by weather.city.name, weather.date desc")
    List<WeatherModel> findAllWeather(CityModel city);
    WeatherModel findByCityAndAndDate(CityModel city, Long date);
}