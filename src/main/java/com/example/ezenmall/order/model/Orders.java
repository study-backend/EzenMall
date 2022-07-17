package com.example.ezenmall.order.model;

import com.example.ezenmall.BaseTimeEntity;
import com.example.ezenmall.member.model.Member;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Table(name =" Orders")
@Entity
public class Orders extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "totalPrice")
    private DecimalFormat totalPrice;
    @Column(name = "buyCount")
    private int buyCount;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn (name= "memberId")
    private Member member;

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


    public void updateOrders(Long id, int buyCount, DecimalFormat totalPrice) {
    }
}
