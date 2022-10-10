package com.hihusky.user.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
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
    public Map<String, Object> handleUsernameDuplicationException(InvalidUsernameOrPasswordException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Invalid username and password");
        return map;
    }

    @ExceptionHandler(JWTDecodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleJWTDecodeException(JWTDecodeException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Invalid JWT token.");
        return map;
    }
}
