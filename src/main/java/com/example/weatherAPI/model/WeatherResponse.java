package com.example.weatherAPI.model;



import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

    @JsonProperty("cod")
    private String cod;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("wind")
    private Wind wind;

    // Getter and Setter methods

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public static class Weather {
        private String main;
        private String description;

        // Getter and Setter methods

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Main {
        private double temp;
        private int humidity;

        // Getter and Setter methods

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public static class Wind {
        private double speed;

        // Getter and Setter methods

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }
}
