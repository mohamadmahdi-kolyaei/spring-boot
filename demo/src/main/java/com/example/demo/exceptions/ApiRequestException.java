package com.example.demo.exceptions;

public class ApiRequestException extends RuntimeException {
    // this is what we are going throw from our cod
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
