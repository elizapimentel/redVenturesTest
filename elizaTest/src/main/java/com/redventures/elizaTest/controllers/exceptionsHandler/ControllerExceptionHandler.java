package com.redventures.elizaTest.controllers.exceptionsHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<StandardError> handleForbiddenHeaderException() {
        var error = StandardError.builder()
                .code(FORBIDDEN.value())
                .error(("x-api-key header missing"))
                .build();
        return ResponseEntity.status(FORBIDDEN).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> invalidRequestException() {
        var error = StandardError.builder()
                .code(BAD_REQUEST.value())
                .error("both brothId and proteinId are required")
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> internalServerErrorException() {
        var error = StandardError.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .error("could not place order")
                .build();

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(error);
    }
}