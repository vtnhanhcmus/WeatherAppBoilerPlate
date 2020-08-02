package com.oddle.app.services.impl;

import com.oddle.app.models.json.OpenWeatherJson;
import com.oddle.app.models.json.WeatherJson;
import com.oddle.app.models.repositories.WeatherRepository;
import com.oddle.app.models.entities.CityModel;
import com.oddle.app.models.entities.WeatherModel;
import com.oddle.app.services.OpenWeatherService;
import com.oddle.app.services.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final CityServiceImpl cityServiceImpl;
    private final OpenWeatherService openWeatherService;

    @Override
    public Iterable<WeatherModel> search(String cityName, Boolean all){

        if (all){
            return weatherRepository.findAll();
        }

        OpenWeatherJson openWeather = openWeatherService.findByCity(cityName);

        final CityModel city = cityServiceImpl.insert(new CityModel(openWeather.getName(), openWeather.getSys().getCountry()));
        create(openWeather, city);
        return findAllWeatherHistory(city);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(OpenWeatherJson owr, CityModel city) {

        final WeatherJson owrWeather = owr.getWeather().get(0);

        WeatherModel weather = weatherRepository.findByCityAndAndDate(city, owr.getDt());

        if (Objects.isNull(weather)){
            weather = WeatherModel.builder()
                    .date(owr.getDt())
                    .temperature(owr.getMain().getTemp())
                    .city(city)
                    .main(owrWeather.getMain())
                    .description(owrWeather.getDescription())
                    .humidity(owr.getMain().getHumidity())
                    .icon(owrWeather.getIcon())
                    .windSpeed(owr.getWind().getSpeed())
                    .clouds(owr.getClouds().getAll())
                    .longitude(owr.getCoord().getLon())
                    .latitude(owr.getCoord().getLat())
                    .build();

            weatherRepository.save(weather);
        }

    }

    public List<WeatherModel> findAllWeatherHistory(CityModel city) {
        List<WeatherModel> weathers = weatherRepository.findAllWeather(city);
        return weathers;
    }

    @Override
    public void delete(WeatherModel data) {
        weatherRepository.delete(data);
    }
}
