package com.example.cashonline.controller;

import com.example.cashonline.persistence.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointer(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                                                        .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInvocationTargetException(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .withStackTrace(e)
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

}
