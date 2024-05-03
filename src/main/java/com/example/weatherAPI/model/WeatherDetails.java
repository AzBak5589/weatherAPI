package com.example.weatherAPI.model;

import java.util.List;

public class WeatherDetails {

    private WeatherData weatherData;
    private List<WeatherForecast> weatherForecast;

    public WeatherDetails() {}

    public WeatherDetails(WeatherData weatherData, List<WeatherForecast> weatherForecast) {
        this.weatherData = weatherData;
        this.weatherForecast = weatherForecast;
    }

    // Getters and Setters
    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public List<WeatherForecast> getWeatherForecast() {
        return weatherForecast;
    }

    public void setWeatherForecast(List<WeatherForecast> weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    // toString method
    @Override
    public String toString() {
        return "WeatherDetails{" +
                "weatherData=" + weatherData +
                ", weatherForecast=" + weatherForecast +
                '}';
    }
}
