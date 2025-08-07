package com.victorgabdev.usercrud.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex) {
        ApplicationErrors error = new ApplicationErrors(
                ex.getMessage(),
                ex.getStatus().value(),
                LocalDateTime.now());

        return new ResponseEntity<>(error, ex.getStatus());
    }
}
