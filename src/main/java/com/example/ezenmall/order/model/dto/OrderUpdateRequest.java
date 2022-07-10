package com.example.ezenmall.order.model.dto;

import java.text.DecimalFormat;

public class OrderUpdateRequest {


    private Long id;
    private DecimalFormat totalPrice;
    private int buyCount;

    public Long getId() {
        return id;
    }

    public DecimalFormat getTotalPrice() {
        return totalPrice;
    }

    public int getBuyCount() {
        return buyCount;
    }
}
