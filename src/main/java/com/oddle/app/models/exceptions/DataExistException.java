package com.oddle.app.models.exceptions;

public class DataExistException extends RuntimeException {
    public DataExistException(String message) {
        super(message);
    }
}
