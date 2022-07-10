package com.example.ezenmall.order.controller;

import com.example.ezenmall.order.model.dto.OrderInsertRequest;
import com.example.ezenmall.order.model.dto.OrderUpdateRequest;
import com.example.ezenmall.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) { this.service = service;}

    @PostMapping
    public void insert(OrderInsertRequest orderInsertRequest) {boolean result = service.insert(orderInsertRequest);}

    @PatchMapping
    public void update(OrderUpdateRequest orderUpdateRequest) {
        boolean result = service.update(orderUpdateRequest);}

    @DeleteMapping("/api/orders/{id}")
    public void delete(@PathVariable Long id) { boolean result = service.delete(id);}
}
