package com.example.crud.springboot_crud_api.service;

import com.example.crud.springboot_crud_api.controller.dto.CreateProductRequestDto;
import com.example.crud.springboot_crud_api.dao.CategoryRepository;
import com.example.crud.springboot_crud_api.dao.ProductRepository;
import com.example.crud.springboot_crud_api.model.entity.Category;
import com.example.crud.springboot_crud_api.model.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product addProduct(CreateProductRequestDto requestDto) {
        System.out.println("In service");
        Product product;
        try{
            System.out.println(requestDto.category_id);
            Optional<Category> category = categoryRepository.findById(requestDto.category_id);
            System.out.println(category.get().getName());
            if (category.isPresent()) {
                product = Product.builder()
                        .price(requestDto.price)
                        .name(requestDto.name)
                        .category(category.get())
                        .build();
                productRepository.save(product);
                System.out.println(productRepository.findAll());
                return product;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
