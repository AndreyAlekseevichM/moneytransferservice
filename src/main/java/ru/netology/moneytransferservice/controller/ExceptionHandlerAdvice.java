package ru.netology.moneytransferservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.moneytransferservice.exception.InputDataException;
import ru.netology.moneytransferservice.response.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InputDataException.class)
    public ResponseEntity<ErrorResponse> handleException(InputDataException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder().message(e.getMessage()).build());
    }
}