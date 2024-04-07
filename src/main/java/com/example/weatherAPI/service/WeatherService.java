package com.example.weatherAPI.service;

import com.example.weatherAPI.model.WeatherData;
import com.example.weatherAPI.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.String;


@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;
    public WeatherData getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
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
