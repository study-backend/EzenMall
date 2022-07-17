package com.example.ezenmall.product.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "kind")
    private String kind;
    @Column(name = "price")
    private int price;
    @Column(name = " author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publishingDate")
    private String publishingDate;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private int description;
    @Column(name = "discountRate")
    private double discountRate;
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {return name; }

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


    public Product(String name, String kind, int price, String author, String publisher, String publishingDate, String image, int description, double discountRate) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
        this.image = image;
        this.description = description;
        this.discountRate = discountRate;
    }

   public void updateProduct(String name, String kind, int price, String author, String publisher, String publishingDate, String image, int description, double discountRate) {
       this.name = name;
       this.kind = kind;
       this.price = price;
       this.author = author;
       this.publisher = publisher;
       this.publishingDate = publishingDate;
       this.image = image;
       this.description = description;
       this.discountRate = discountRate;

   }


}
