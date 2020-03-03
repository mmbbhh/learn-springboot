package com.day08.day08.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }
    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
    @GetMapping("/db/hello")
    public String db() {
        return "hello dba";
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
