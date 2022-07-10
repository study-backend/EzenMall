package com.example.ezenmall.order.repository;

import com.example.ezenmall.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long > {



}
