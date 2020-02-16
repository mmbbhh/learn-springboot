package com.day04.day04.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    public String addBook(String name) {
        return "receive:" + name;
    }
    @DeleteMapping("/{id}")
    public String deleteBookId(@PathVariable Long id) {
        return  String.valueOf(id);
    }
}
