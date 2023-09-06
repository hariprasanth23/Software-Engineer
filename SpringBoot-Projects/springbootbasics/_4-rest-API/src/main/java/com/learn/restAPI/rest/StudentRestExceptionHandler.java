package com.learn.restAPI.rest;

import com.learn.restAPI.entity.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error =
                StudentErrorResponse.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(exc.getMessage())
                        .timeStamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error =
                StudentErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(exc.getMessage())
                        .timeStamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
}
