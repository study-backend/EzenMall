package com.example.ezenmall.order.service;
import com.example.ezenmall.order.model.Orders;
import com.example.ezenmall.order.model.dto.OrderInsertRequest;
import com.example.ezenmall.order.model.dto.OrderUpdateRequest;
import com.example.ezenmall.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class OrderService {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {this.repository = repository;}

    public boolean insert(OrderInsertRequest orderInsertRequest) {


        Orders orders = new Orders(orderInsertRequest.getId(), orderInsertRequest.getBuyCount(),
                orderInsertRequest.getTotalPrice());

        Orders newOrders = repository.save(orders);

        if(newOrders.getId().equals(orders.getId()))
            return true;
        else
            return false;
    }

    public boolean update(OrderUpdateRequest orderUpdateRequest) {
        Optional<Orders> findOrders = repository.findById(orderUpdateRequest.getId());
        if(findOrders.isEmpty()) return false;
        findOrders.get().updateOrders(orderUpdateRequest.getId(), orderUpdateRequest.getBuyCount(),
                orderUpdateRequest.getTotalPrice());

        Orders orders = repository.save(findOrders.get());
        return true;
    }

    public boolean delete(Long id) {
        Optional<Orders> findOrders = repository.findById((id));
        if(findOrders.isEmpty()) return false;
        repository.delete(findOrders.get());
        return true;

    }
}
