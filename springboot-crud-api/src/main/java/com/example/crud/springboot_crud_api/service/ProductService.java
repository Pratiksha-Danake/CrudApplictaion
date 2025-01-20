package com.example.crud.springboot_crud_api.service;

import com.example.crud.springboot_crud_api.dao.ProductRepository;
import com.example.crud.springboot_crud_api.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
