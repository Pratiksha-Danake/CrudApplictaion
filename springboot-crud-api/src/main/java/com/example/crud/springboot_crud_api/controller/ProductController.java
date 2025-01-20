package com.example.crud.springboot_crud_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/products")
    public void getAllProducts(){
        System.out.println("Getting All Products");
    }
}
