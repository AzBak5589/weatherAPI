package com.example.weatherAPI.service;

import com.example.weatherAPI.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoLocationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${geolocation.api.url}")
    private String geoLocationApiUrl;

    @Value("${geolocation.api.key}")
    private String apiKey;

    public GeoLocation getGeoLocation(String ipAddress) {
        String apiUrl = geoLocationApiUrl.replace("{apiKey}", apiKey) + "&ip=" + ipAddress;

        try {
            return restTemplate.getForObject(apiUrl, GeoLocation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
