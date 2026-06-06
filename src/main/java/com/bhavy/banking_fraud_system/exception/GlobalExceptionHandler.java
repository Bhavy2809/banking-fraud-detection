package com.bhavy.banking_fraud_system.exception;
import com.bhavy.banking_fraud_system.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(
            RuntimeException ex) {

        return new ErrorResponse(
                ex.getMessage(),
                400
        );
    }
}