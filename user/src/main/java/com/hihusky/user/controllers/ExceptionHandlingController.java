package com.hihusky.user.controllers;

import com.hihusky.user.exceptions.InvalidUsernameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(InvalidUsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, Object>> handleUsernameDuplicationException(InvalidUsernameOrPasswordException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "invalid username and password");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_ACCEPTABLE);
    }
}
