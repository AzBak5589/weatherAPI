package com.example.weatherAPI.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConversionServiceTest {

    private UnitConversionService unitConversionService;

    @BeforeEach
    public void setUp() {
        unitConversionService = new UnitConversionService();
    }

    @Test
    public void testCelsiusToFahrenheit() {
        double result = unitConversionService.celsiusToFahrenheit(0);
        assertEquals(32, result);
    }
}
