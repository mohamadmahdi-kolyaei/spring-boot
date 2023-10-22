package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class ApiException { // this can be a record
    // what the client will see
    private final String massage;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

//    public ApiException(String massage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
//        this.massage = massage;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.zonedDateTime = zonedDateTime;
//    }

//    public String getMassage() {
//        return massage;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }
//
//    public ZonedDateTime getZonedDateTime() {
//        return zonedDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ApiException{" +
//                "massage='" + massage + '\'' +
//                ", throwable=" + throwable +
//                ", httpStatus=" + httpStatus +
//                ", zonedDateTime=" + zonedDateTime +
//                '}';
//    }
}
