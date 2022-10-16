package com.hihusky.jp_lang.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to jp-lang project!";
    }
}
