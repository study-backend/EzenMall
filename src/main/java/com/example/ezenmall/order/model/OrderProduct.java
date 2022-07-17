package com.example.ezenmall.order.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Table
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "orderId")
    private Long orderId;
    @Column(name = "productId")
    private Long productId;
    @Column(name = "discountRate")
    private DecimalFormat discountPrice;
    @Column(name = " createDate")
    private LocalDateTime createDate;
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @ManyToOne
    private Orders orders;

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public DecimalFormat getDiscountPrice() {
        return discountPrice;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
