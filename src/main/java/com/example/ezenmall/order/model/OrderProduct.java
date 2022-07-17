package com.example.ezenmall.order.model;

import com.example.ezenmall.BaseTimeEntity;
import com.example.ezenmall.product.model.Product;

import javax.persistence.*;
import java.text.DecimalFormat;

@Table
@Entity
public class OrderProduct extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "discountPrice")
    private DecimalFormat discountPrice;


    @ManyToOne
    @JoinColumn (name= "orderId")
    private Orders order;

    @ManyToOne
    @JoinColumn (name= "productId")
    private Product product;

    public Long getId() {
        return id;
    }

    public Long getOrders() {
        return order.getId();
    }

    public Long getProducts() {
        return product.getId();
    }

    public DecimalFormat getDiscountPrice() {
        return discountPrice;
    }


}
