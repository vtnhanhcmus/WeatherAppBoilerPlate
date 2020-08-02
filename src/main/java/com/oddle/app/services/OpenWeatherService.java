package com.oddle.app.services;
import com.oddle.app.models.json.OpenWeatherJson;

public interface OpenWeatherService {
    OpenWeatherJson findByCity(String cityName);
}
