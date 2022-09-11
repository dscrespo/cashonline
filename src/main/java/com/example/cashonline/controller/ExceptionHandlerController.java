package com.example.cashonline.controller;

import com.example.cashonline.persistence.ErrorResponse;
import com.example.cashonline.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointer(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .build();
        logger.error("Ocurrio un error en : " + getStackTraceToString(e));
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                                                        .build();
        logger.error("Ocurrio un error en : " + getStackTraceToString(e));
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInvocationTargetException(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST; // 404
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .withStackTrace(getStackTraceToString(e))
                .build();
        logger.error("Ocurrio un error en : " + getStackTraceToString(e));
        return new ResponseEntity<>(errorResponse, status);
    }

    private String getStackTraceToString(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
