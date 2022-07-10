package com.example.ezenmall.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column()
    private Long id;
    @Column
    private String name;
    @Column()
    private String kind;
    @Column() private int price;
    @Column() private String author;
    @Column() private String publisher;
    @Column() private String publishingDate;
    @Column() private String image;
    @Column() private int description;
    @Column() private double discountRate;
    @Column(name = "createDate") private LocalDateTime createDate;
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
