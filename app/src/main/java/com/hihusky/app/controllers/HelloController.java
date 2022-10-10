package com.hihusky.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    String greet() {
        return "Hello, welcome the ONE PUNCH API.";
    }
}
