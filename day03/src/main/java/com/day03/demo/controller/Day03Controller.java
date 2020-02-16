package com.day03.demo.controller;

import com.day03.demo.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Day03Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Springboot";
    }

    @GetMapping("/book")
    public Book book() {
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30f);
        book.setPublicationDate(new Date());
        return book;
    }

    @GetMapping("/home")
    public String home() {
        int i = 1 / 0;
        return "home";
    }
}
