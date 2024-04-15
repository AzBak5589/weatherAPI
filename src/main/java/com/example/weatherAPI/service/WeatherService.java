package com.example.weatherAPI.service;

import com.example.weatherAPI.model.WeatherData;
import com.example.weatherAPI.model.WeatherForecast;
import com.example.weatherAPI.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);


    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${geolocation.api.key}")
    private String geolocationApiKey;

    @Value("${openweathermap.api.forecast.url}")
    private String apiForecastUrl;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherData getWeatherData(String city) {
        String formattedApiUrl = String.format(apiUrl, city, apiKey);

        try {
            WeatherResponse response = restTemplate.getForObject(formattedApiUrl, WeatherResponse.class);
            if (response != null && !"404".equals(response.getCod())) {
                return convertToWeatherData(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public WeatherForecast getWeatherForecast(String city) {
        String forecastUrl = String.format("https://api.openweathermap.org/data/2.5/forecast?q=%s&units=metric&appid=%s", city, apiKey);

        try {
            return restTemplate.getForObject(forecastUrl, WeatherForecast.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Handle 404 Not Found error
                System.out.println("City not found: " + city);
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private WeatherData convertToWeatherData(WeatherResponse response) {
        WeatherData weatherData = new WeatherData();

        switch (response.getWeather()[0].getMain()) {
            case "Clear":
                weatherData.setImage("images/clear.jpg.avif");
                break;
            case "Rain":
                weatherData.setImage("images/rain.jpeg");
                break;
            case "Snow":
                weatherData.setImage("images/snow.jpeg");
                break;
            case "Clouds":
                weatherData.setImage("images/cloud.jpeg");
                break;
            case "Mist":
                weatherData.setImage("images/mist.jpeg");
                break;
            case "Haze":
                weatherData.setImage("images/haze.jpg");
                break;
            default:
                weatherData.setImage("images/clear.jpg.avif");
        }

        weatherData.setTemperature(String.valueOf((int) response.getMain().getTemp()) + "°C");
        weatherData.setDescription(response.getWeather()[0].getDescription());
        weatherData.setHumidity(String.valueOf(response.getMain().getHumidity()) + "%");
        weatherData.setWind(String.valueOf((int) response.getWind().getSpeed()) + "Km/h");

        return weatherData;
    }
}
