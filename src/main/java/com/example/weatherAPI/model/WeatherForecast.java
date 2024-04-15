package com.example.weatherAPI.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherForecast {
    private String cod;
    private int message;
    private int cnt;
    private List<Forecast> list;
    private City city;
    // Getters and Setters
    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("message")
    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    @JsonProperty("cnt")
    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @JsonProperty("list")
    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}

