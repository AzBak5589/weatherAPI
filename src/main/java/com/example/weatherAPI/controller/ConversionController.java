package com.example.weatherAPI.controller;

import com.example.weatherAPI.service.UnitConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    private UnitConversionService unitConversionService;

    @GetMapping("/celsiusToFahrenheit")
    public ResponseEntity<Double> celsiusToFahrenheit(@RequestParam double celsius) {
        double result = unitConversionService.celsiusToFahrenheit(celsius);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/fahrenheitToCelsius")
    public ResponseEntity<Double> fahrenheitToCelsius(@RequestParam double fahrenheit) {
        double result = unitConversionService.fahrenheitToCelsius(fahrenheit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/metersToMiles")
    public ResponseEntity<Double> metersToMiles(@RequestParam double meters) {
        double result = unitConversionService.metersToMiles(meters);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/milesToMeters")
    public ResponseEntity<Double> milesToMeters(@RequestParam double miles) {
        double result = unitConversionService.milesToMeters(miles);
        return ResponseEntity.ok(result);
    }

}

