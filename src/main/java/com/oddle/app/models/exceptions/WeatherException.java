package com.oddle.app.models.exceptions;

public class WeatherException extends RuntimeException{

    public WeatherException(String message) {
        super(message);
    }
}
