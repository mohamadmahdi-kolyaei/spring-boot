package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)    // it allows us to change status code
public class NotFoundException extends RuntimeException {
    public NotFoundException(String massage) {

        super(massage);
    }
}
