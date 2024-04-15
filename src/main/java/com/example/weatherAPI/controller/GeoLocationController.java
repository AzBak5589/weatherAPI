package com.example.weatherAPI.controller;

import com.example.weatherAPI.model.GeoLocation;
import com.example.weatherAPI.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @GetMapping("/api/geolocation")
    public GeoLocation getGeoLocation(@RequestParam(required = false, defaultValue = "me") String ipAddress) {
        return geoLocationService.getGeoLocation(ipAddress);
    }
}
