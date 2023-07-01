package com.example.weather_app.json;

import com.example.weather_app.models.WeatherNow;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherRestMap {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    @Value("${api.key}")
    String apiKey;

    private final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";


    public WeatherNow getWeatherByCityNow(String city) throws JsonProcessingException {
        ResponseEntity<String> response =
                restTemplate.getForEntity(String.format(WEATHER_URL, city, apiKey), String.class);

        return mapResponseToWeather(response);
    }

    public WeatherNow mapResponseToWeather(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode main = root.path("main");
        JsonNode weather = root.path("weather");

        WeatherNow weatherNow = new WeatherNow();

        weatherNow.setMain(weather.findPath("main").asText());
        weatherNow.setDescription(weather.findPath("description").asText());
        weatherNow.setTemp(main.path("temp").asInt());
        weatherNow.setFeels_like(main.path("feels_like").asInt());
        weatherNow.setHumidity(main.path("humidity").asInt());

        return weatherNow;
    }
}
