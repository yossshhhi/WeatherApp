package com.example.weather_app.json;

import com.example.weather_app.models.WeatherNow;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

//class WeatherRestMapTest {
//
//    RestTemplate restTemplate = new RestTemplate();
//    WeatherRestMap weatherRestMap = new WeatherRestMap();
//
//    @Test
//    void getWeatherNow() {
//        String city = "London";
//        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=9b4ff7494391c5863b37b9ee8d9387cb&units=metric";
//        assertEquals(restTemplate.getForObject(url, WeatherNow.class), weatherRestMap.getWeatherNow(city));
//
//    }
//}