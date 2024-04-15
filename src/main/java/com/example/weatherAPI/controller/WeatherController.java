package com.example.weatherAPI.controller;

import com.example.weatherAPI.model.WeatherData;
import com.example.weatherAPI.model.WeatherForecast;
import com.example.weatherAPI.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
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
        WeatherForecast weatherForecast = weatherService.getWeatherForecast(city);

        if (weatherData != null) {
            model.addAttribute("weatherData", weatherData);
        } else {
            model.addAttribute("error", "Location not found!!");
        }

        if (weatherForecast != null) {
            model.addAttribute("weatherForecast", weatherForecast);
        }

        return "index";
    }

    @GetMapping(value = "/api/forecast/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getWeatherForecast(@PathVariable String city) {
        WeatherForecast forecast = weatherService.getWeatherForecast(city);
        if (forecast != null) {
            return ResponseEntity.ok(forecast);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/weather/{city}")
    public ResponseEntity<WeatherData> getWeatherData(@PathVariable String city) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        if (weatherData != null) {
            return ResponseEntity.ok(weatherData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
