package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_KEY = "578e8f43c7976bfb54bc48cecd7fda94";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

    public WeatherData getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = String.format(API_URL, city, API_KEY);

        try {
            WeatherResponse response = restTemplate.getForObject(apiUrl, WeatherResponse.class);
            if (response != null && !"404".equals(response.getCod())) {
                return convertToWeatherData(response);
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
