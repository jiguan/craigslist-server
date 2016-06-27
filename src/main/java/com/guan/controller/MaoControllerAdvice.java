package com.guan.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.guan.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class MaoControllerAdvice {

    @ExceptionHandler({ResourceNotFoundException.class, TypeMismatchException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(Exception e) {
        return e.getMessage();
    }
}
