package com.example.weatherAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UnitConversionService {

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public double milesToMeters(double miles) {
        return miles / 0.000621371;
    }

    @Value("${conversion.factor.metersToMiles}")
    private double metersToMilesFactor;

    public double metersToMiles(double meters) {
        return meters * metersToMilesFactor;
    }

}
