package com.example.ezenmall.product.controller;

import com.example.ezenmall.product.model.dto.ProductInsertRequest;
import com.example.ezenmall.product.model.dto.ProductUpdateRequest;
import com.example.ezenmall.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/products")
@RestController
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {this.service = service;}
    @PostMapping(value = "")
    public void insert(ProductInsertRequest request) { boolean result = service.insert(request);}

    @PatchMapping(value = "")
    public void update(ProductUpdateRequest productUpdateRequest) { boolean result = service.update(productUpdateRequest);}

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) { boolean result = service.delete(id);}
}
