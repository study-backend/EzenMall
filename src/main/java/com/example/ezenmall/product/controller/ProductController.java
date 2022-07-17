package com.example.ezenmall.product.controller;

import com.example.ezenmall.product.model.dto.ProductInsertRequest;
import com.example.ezenmall.product.model.dto.ProductUpdateRequest;
import com.example.ezenmall.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/products")
@Controller
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {this.service = service;}
    @PostMapping(name = "")
    public void insert(ProductInsertRequest request) { boolean result = service.insert(request);}

    @PatchMapping(name = "")
    public void update(ProductUpdateRequest productUpdateRequest) { boolean result = service.update(productUpdateRequest);}

    @DeleteMapping(name = "/{id}")
    public void delete(@PathVariable Long id) { boolean result = service.delete(id);}
}
