package com.example.ezenmall.order.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "totalPrice")
    private DecimalFormat totalPrice;
    @Column(name = "buyCount")
    private int buyCount;
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @Column(name = "updateTime")
    private LocalDateTime updateTime;

    @OneToMany
    private List<OrderProduct> products = new ArrayList<>();


    public Orders(Long id, int buyCount, DecimalFormat totalPrice) {
    }

    public Orders() {

    }

    public Long getId() {
        return id;
    }

    public DecimalFormat getTotalPrice() {
        return totalPrice;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void updateOrders(Long id, int buyCount, DecimalFormat totalPrice) {
    }
}
