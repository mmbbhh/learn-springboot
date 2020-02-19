package com.day05.day05.model;

public class Book {
    private Integer id;
    private String name;
    private String author;

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
