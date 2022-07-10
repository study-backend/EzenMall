package com.example.ezenmall.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Table
@Entity
public class OrderProduct {
    @Column
    @Id
    private Long id;
    @Column
    private Long orderId;
    @Column
    private Long productId;
    @Column
    private DecimalFormat discountPrice;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;

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
