package com.example.weatherAPI.model;

import java.util.List;

public class Forecast {
    private int dt;
    private Main main;
    private List<Weather> weather;

    // Getters and Setters
    // ...
    // Getters
    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    // Setters
    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
