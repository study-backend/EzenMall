package com.example.ezenmall.order.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Table
@Entity
public class Orders {

    private Long id;
    private DecimalFormat totalPrice;
    private int buyCount;
    private LocalDateTime createDate;
    private LocalDateTime updateTime;
    private Long memberId;

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

    public Long getMemberId() {
        return memberId;
    }
}
