package com.spring.demo.SpringBoot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String, String> exceptionHandler (ResourceNotFoundException resourceNotFoundException){
        Map<String, String> erroMap = new HashMap<>();
        erroMap.put("erroMessage", resourceNotFoundException.getMessage());
        return erroMap;

    }
}
