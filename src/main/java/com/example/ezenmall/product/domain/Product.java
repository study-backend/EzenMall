package com.example.ezenmall.product.domain;

import java.time.LocalDateTime;

public class Product {

    private Long id;
    private String kind;
    private int price;
    private String author;
    private String publisher;
    private String publishingDate;
    private String image;
    private int discription;
    private double discountRate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public String getKind() {
        return kind;
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

    public int getDiscription() {
        return discription;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
