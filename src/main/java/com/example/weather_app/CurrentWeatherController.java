package com.example.weather_app;

import com.example.weather_app.error.ApiError;
import com.example.weather_app.json.WeatherRestMap;
import com.example.weather_app.models.WeatherNow;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/")
@ControllerAdvice
public class CurrentWeatherController {

    @Autowired
    private WeatherRestMap weatherRestMap;

    @GetMapping(value = "/now", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherNow getJson(@RequestParam String city) throws JsonProcessingException {
        return weatherRestMap.getWeatherByCityNow(city);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Missing parameter",
                "Invalid request, write '" + name + "' name"
        );
        return apiError;
    }
}
