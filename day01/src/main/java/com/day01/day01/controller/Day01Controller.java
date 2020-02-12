package com.day01.day01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day01Controller {

    @GetMapping("/hello")
    public String shiyanlou() {
        return "Hello Springboot";
    }
}