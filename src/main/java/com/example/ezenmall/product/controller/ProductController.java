package com.example.ezenmall.product.controller;

import com.example.ezenmall.product.model.dto.ProductInsertRequest;
import com.example.ezenmall.product.model.dto.ProductUpdateRequest;
import com.example.ezenmall.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {this.service = service;}
    @PostMapping
    public void insert(ProductInsertRequest request) { boolean result = service.insert(request);}

    @PatchMapping
    public void update(ProductUpdateRequest productUpdateRequest) { boolean result = service.update(productUpdateRequest);}

    @DeleteMapping
    public void delete(@PathVariable Long id) { boolean result = service.delete(id);}
}
