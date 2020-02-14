package com.day01.day01.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

//定义书本类
public class Book {
    private String name;
    private String author;
    @JsonIgnore //字段忽略
    private Float price;
    @JsonFormat (pattern = "yyyy-mm-dd") //日期格式化
    private Date publicationDate;

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setPublicationDate(Date date) {
        this.publicationDate = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
