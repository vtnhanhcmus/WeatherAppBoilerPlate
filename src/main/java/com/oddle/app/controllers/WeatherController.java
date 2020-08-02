package com.oddle.app.controllers;

import com.oddle.app.models.entities.WeatherModel;
import com.oddle.app.services.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping({"/"})
    public String home(Model model) {
        Iterable<WeatherModel> weathers =  weatherService.search(null, true);
        model.addAttribute("weathers", weathers);
        return "list";
    }


}
