package com.example.weatherapp.model;

public class WeatherResponse {
    private String cod;
    private Weather[] weather;
    private Main main;
    private Wind wind;

    // Getters and setters
}

class Weather {
    private String main;
    private String description;

    // Getters and setters
}

class Main {
    private double temp;
    private int humidity;

    // Getters and setters
}

class Wind {
    private double speed;

    // Getters and setters
}


