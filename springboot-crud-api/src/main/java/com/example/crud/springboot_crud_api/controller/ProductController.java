package com.example.crud.springboot_crud_api.controller;

import com.example.crud.springboot_crud_api.controller.dto.CreateProductRequestDto;
import com.example.crud.springboot_crud_api.model.entity.Product;
import com.example.crud.springboot_crud_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public ResponseEntity<Object> addProduct(@RequestBody CreateProductRequestDto requestDto){
        try {
            Product savedProduct = productService.addProduct(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the product.");
        }
    }
}
