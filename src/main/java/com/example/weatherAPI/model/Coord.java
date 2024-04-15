package com.example.weatherAPI.model;

public class Coord {
    private double lat;
    private double lon;

    // Getters and Setters
    // ...
    // Getters
    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    // Setters
    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}