package com.oddle.app.services;

import com.oddle.app.models.entities.WeatherModel;

public interface WeatherService extends DeleteService<WeatherModel>{
    Iterable<WeatherModel> search(String cityName, Boolean all);
}
