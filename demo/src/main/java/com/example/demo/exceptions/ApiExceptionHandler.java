package com.example.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice // in order to this class work for all controllers or across entire application
public class ApiExceptionHandler {
    // this is what we are going to use build a response to our client
    // this is allowed us handling more than one exception

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiRequestException.class);


    //In the context of Java Spring framework, ResponseEntity<T> is a class that represents the HTTP response in a more flexible way,
    // allowing you to customize the response status, headers, and body. It is commonly used in Spring web applications to return responses from controller methods.
    //
    //The ResponseEntity<T> class is a part of the Spring Web module, and it is a parameterized class that takes a type parameter T,
    // representing the type of the response body. By using this class, you can set the HTTP status code, headers, and body to be returned in the response.
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(
        ApiRequestException e
    ){
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(
            NotFoundException e
    ){
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException , HttpStatus.NOT_FOUND);
    }


    // just for example

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGeneralException(Exception ex) {
//        // Handle other types of exceptions, e.g., log them and return a generic error response.
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
//        // Handle the ResourceNotFoundException, e.g., log it and return a custom error response.
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + ex.getMessage());
//    }
}
