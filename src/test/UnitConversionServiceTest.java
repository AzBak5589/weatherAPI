package test;

import com.example.weatherAPI.service.UnitConversionService;
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
        double fahrenheit = unitConversionService.celsiusToFahrenheit(25);
        assertEquals(77, fahrenheit, 0.01, "25°C should be 77°F");
    }

    @Test
    public void testFahrenheitToCelsius() {
        double celsius = unitConversionService.fahrenheitToCelsius(77);
        assertEquals(25, celsius, 0.01, "77°F should be 25°C");
    }


}