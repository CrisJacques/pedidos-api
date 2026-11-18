package com.example.produtosapi.controller.exception;

import com.example.produtosapi.service.exception.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFound(ProductNotFoundException e,  HttpServletRequest request) {
        String message = e.getMessage();
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String path = request.getRequestURI();

        ErrorResponse err = new ErrorResponse(message, timestamp, status.value(), path);

        return ResponseEntity.status(status).body(err);

    }

}
