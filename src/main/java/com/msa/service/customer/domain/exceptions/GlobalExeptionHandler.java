package com.msa.service.customer.domain.exceptions;

import com.ms.customer.service.server.models.Error;
import com.ms.customer.service.server.models.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(InvalidateIdentificationException.class)
    public ResponseEntity<Error> handleInvalidIdentification(InvalidateIdentificationException ex){
        Error error = new Error();
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setMessage(ex.getMessage());
        error.setTitle("Invalid Identification");
        error.setDetail("Invalid Identification");
        error.setErrors(Collections.singletonList(errorDetail));
        error.setStatus(400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Void> handleCustomException(CustomerNotFoundException ex){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
