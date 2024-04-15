package com.example.weatherAPI.model;

public class City {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int timezone;
    private int sunrise;
    private int sunset;

    // Getters and Setters
    // ...

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getTimezone() {
        return timezone;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}