package com.foreverchild.spring_boot_rest_crud.exception;

import com.foreverchild.spring_boot_rest_crud.dto.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<StudentErrorResponse> handleException (Exception ex){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setStatusMessage(ex.getMessage());
        error.setStatusMessage(LocalDateTime.now().toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
