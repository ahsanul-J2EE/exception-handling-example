package com.bjit.main.controller;

import com.bjit.main.exception.AdminNotFoundException;
import com.bjit.main.exception.CandidateNotFoundException;
import com.bjit.main.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class, ArithmeticException.class,
            CandidateNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if(ex instanceof AdminNotFoundException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else if(ex instanceof CandidateNotFoundException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
