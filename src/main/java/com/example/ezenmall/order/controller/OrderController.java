package com.example.ezenmall.order.controller;

import com.example.ezenmall.order.model.dto.OrderInsertRequest;
import com.example.ezenmall.order.model.dto.OrderUpdateRequest;
import com.example.ezenmall.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/orders")
@Controller
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) { this.service = service;}

    @PostMapping(name = "")
    public void insert(OrderInsertRequest orderInsertRequest) {boolean result = service.insert(orderInsertRequest);}

    @PatchMapping(name = "")
    public void update(OrderUpdateRequest orderUpdateRequest) {
        boolean result = service.update(orderUpdateRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { boolean result = service.delete(id);}
}
