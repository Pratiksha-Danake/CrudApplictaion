package com.example.crud.springboot_crud_api.controller;

import com.example.crud.springboot_crud_api.model.entity.Product;
import com.example.crud.springboot_crud_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }
}
