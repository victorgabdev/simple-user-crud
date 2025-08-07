package com.victorgabdev.usercrud.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex,  HttpServletRequest request) {
        ApplicationErrors error = new ApplicationErrors(
                ex.getMessage(),
                ex.getStatus().value(),
                LocalDateTime.now(),
                request.getRequestURI(),
                "NOT FOUND");

        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handleNotFond(NoHandlerFoundException ex) {
        ApplicationErrors error = new ApplicationErrors(
                ex.getMessage(),
                ex.getStatusCode().value(),
                LocalDateTime.now(),
                ex.getRequestURL(),
                "Página ou rota não encontrada."
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNotFond(NoResourceFoundException ex, HttpServletRequest request) {
        ApplicationErrors error = new ApplicationErrors(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                request.getRequestURI(),
                "Recurso não encontrado"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
