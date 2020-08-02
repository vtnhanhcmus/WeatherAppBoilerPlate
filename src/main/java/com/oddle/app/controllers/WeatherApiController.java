package com.oddle.app.controllers;

import com.oddle.app.models.entities.WeatherModel;
import com.oddle.app.services.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WeatherApiController {

    @Autowired
    private WeatherServiceImpl weatherServiceImpl;

    @RequestMapping(value = "/weather")
    @ResponseBody
    public ResponseEntity search(@RequestParam(value="q")String cityName, @RequestParam(value = "all", defaultValue = "0") Boolean all){
        Iterable<WeatherModel> weathers = weatherServiceImpl.search(cityName, all);
        return ResponseEntity.status(200).body(weathers);
    }

}
