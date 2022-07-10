package com.example.ezenmall.product.service;

import com.example.ezenmall.product.model.dto.ProductInsertRequest;
import com.example.ezenmall.product.model.Product;
import com.example.ezenmall.product.model.dto.ProductUpdateRequest;
import com.example.ezenmall.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository repository;


    public ProductService(ProductRepository repository) {this.repository = repository;}

    public boolean insert(ProductInsertRequest productInsertRequest) {

        Optional <Product> findProduct = repository.findByName(productInsertRequest.getName());

        if(findProduct.isPresent()) return false;

        Product product = new Product(productInsertRequest.getName(), productInsertRequest.getKind(),productInsertRequest.getPrice(),productInsertRequest.getAuthor(),
                productInsertRequest.getPublisher(), productInsertRequest.getPublishingDate(), productInsertRequest.getImage(),
                productInsertRequest.getDescription(),productInsertRequest.getDiscountRate());

        repository.save(product);
        return true;
    }

    public boolean update(ProductUpdateRequest productUpdateRequest) {
        Optional<Product> findProduct = repository.findById(productUpdateRequest.getId());
        if(findProduct.isEmpty()) return false;
        findProduct.get().updateProduct(productUpdateRequest.getName(),
                productUpdateRequest.getKind(), productUpdateRequest.getPrice(), productUpdateRequest.getAuthor(),
                productUpdateRequest.getPublisher(),
                productUpdateRequest.getPublishingDate(),productUpdateRequest.getImage(),
                productUpdateRequest.getDescription(), productUpdateRequest.getDiscountRate());


        Product updateProduct = repository.save(findProduct.get());
        return true;
    }

    public boolean delete(Long id ) {
        Optional<Product> findProduct = repository.findById((id));
        if(findProduct.isEmpty()) return false;
        repository.delete(findProduct.get());
        return true;
    }
}
