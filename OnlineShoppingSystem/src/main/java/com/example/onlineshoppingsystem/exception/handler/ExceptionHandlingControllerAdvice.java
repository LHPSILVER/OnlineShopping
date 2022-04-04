package com.example.onlineshoppingsystem.exception.handler;

import com.example.onlineshoppingsystem.dto.response.ErrorResponse;
import com.example.onlineshoppingsystem.exception.InvalidInputDataException;
import com.example.onlineshoppingsystem.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputDataException.class)
    public ResponseEntity handleInvalidInputDataException(InvalidInputDataException exception) {
        StringBuilder errors = new StringBuilder();
        exception.getErrors().forEach((field, message) -> errors.append(field).append(" ").append(message).append(" and "));
        String substring = errors.substring(0, errors.length() - 5);

        return new ResponseEntity(new ErrorResponse(substring), HttpStatus.BAD_REQUEST);
    }
}
