package com.oddle.app.services.impl;

import com.oddle.app.models.json.OpenWeatherJson;
import com.oddle.app.services.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String weatherUrl;

    @Override
    public OpenWeatherJson findByCity(String cityName) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<OpenWeatherJson> responseEntity = restTemplate.exchange(
                String.format(weatherUrl, cityName),
                HttpMethod.GET,
                httpEntity,
                OpenWeatherJson.class
        );

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        return responseEntity.getBody();
    }
}
