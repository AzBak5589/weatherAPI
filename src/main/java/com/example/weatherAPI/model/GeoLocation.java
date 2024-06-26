package com.example.weatherAPI.model;

public class GeoLocation {
    private String ip;
    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private double latitude;
    private double longitude;
    private String zip_code;
    private String time_zone;
    private String metro_code;

    // Getters
    public String getIp() {
        return ip;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public String getMetro_code() {
        return metro_code;
    }

    // Setters
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public void setMetro_code(String metro_code) {
        this.metro_code = metro_code;
    }
}
