package com.day01.day01.controller;

import com.day01.day01.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Day01Controller {

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
}
