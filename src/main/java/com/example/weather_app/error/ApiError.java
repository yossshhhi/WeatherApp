package com.example.weather_app.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    private String detailedMessage;

    public ApiError(HttpStatus status, String message, String detailedMessage) {
        this.status = status;
        this.message = message;
        this.detailedMessage = detailedMessage;
    }
}
