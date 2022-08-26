package com.komal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ControllerAdvice //To HANDLE VALIDATION AND EXCEPTION IN A SINGLE PLACE
public class EmployeeValidationException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,String > errors=new HashMap<String ,String >();
        ex.getBindingResult().getAllErrors().forEach((error)->{

            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });

    return ResponseEntity.ok(errors);



    }


}
