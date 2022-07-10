package com.example.ezenmall.product.model.dto;

import java.time.LocalDateTime;

public class ProductUpdateRequest {

    private Long id;
    private String kind;
    private String name;
    private int price;
    private String author;
    private String publisher;
    private String publishingDate;
    private String image;
    private int description;
    private double discountRate;


    public Long getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public String getImage() {
        return image;
    }

    public int getDescription() {
        return description;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
