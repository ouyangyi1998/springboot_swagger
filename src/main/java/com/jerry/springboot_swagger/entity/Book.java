package com.jerry.springboot_swagger.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private long id;
    private String name;
    private double price;
}
