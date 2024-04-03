package com.example.weatherAPI.controller;

import com.example.weatherAPI.model.WeatherData;
import com.example.weatherAPI.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/search")
    public String searchWeather(@RequestParam String city, Model model) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        if (weatherData != null) {
            model.addAttribute("weatherData", weatherData);
        } else {
            model.addAttribute("error", "Location not found!!");
        }
        return "index";
    }
}
