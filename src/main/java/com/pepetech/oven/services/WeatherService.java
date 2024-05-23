package com.pepetech.oven.services;
// Java
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Getter
    private static Object currentWeatherData;

    private final String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?q=Medellin&appid=d1fe1c1afcbd332ceeda376fffa9bfb0&units=metric";

    @Scheduled(fixedRate = 1000*60*60) // Run every hour
    public void fetchWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        currentWeatherData = restTemplate.getForObject(weatherUrl, Object.class);
    }
}