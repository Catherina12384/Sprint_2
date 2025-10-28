package com.SpaceFinders.Sprint_2.Controller;

import com.SpaceFinders.Sprint_2.Utility.AlreadyExistsException;
import com.SpaceFinders.Sprint_2.Utility.DataNotFoundException;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((e.getMessage()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExistsException(AlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.FOUND).body((e.getMessage()));
    }
}
