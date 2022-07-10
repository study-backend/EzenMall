package com.example.ezenmall.product.model.dto;

import java.time.LocalDateTime;

public class ProductInsertRequest {
    private  String name;
    private String kind;
    private int price;
    private String author;
    private String publisher;
    private String publishingDate;
    private String image;
    private int description;
    private double discountRate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;



    public String getKind() {
        return kind;
    }
    public String getName() { return name;}

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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
