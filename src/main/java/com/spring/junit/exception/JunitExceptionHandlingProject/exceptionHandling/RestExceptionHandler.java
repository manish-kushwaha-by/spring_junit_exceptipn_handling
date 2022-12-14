package com.spring.junit.exception.JunitExceptionHandlingProject.exceptionHandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class RestExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponse> exceptionEmployeeHandler(Exception err){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(err.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception err){
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("THE REQUEST CANNOT BE PLACED DUE TO MALFUNCTION SYNTAX.");
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
