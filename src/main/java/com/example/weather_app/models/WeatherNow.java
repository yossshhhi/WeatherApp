package com.example.weather_app.models;

import lombok.Data;

@Data
public class WeatherNow {
    private String main;
    private String description;
    private int temp;
    private int feels_like;
    private int humidity;
}
