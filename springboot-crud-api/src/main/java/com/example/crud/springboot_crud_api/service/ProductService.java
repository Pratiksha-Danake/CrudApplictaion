package com.example.crud.springboot_crud_api.service;

import com.example.crud.springboot_crud_api.controller.dto.CreateProductRequestDto;
import com.example.crud.springboot_crud_api.dao.CategoryRepository;
import com.example.crud.springboot_crud_api.dao.ProductRepository;
import com.example.crud.springboot_crud_api.model.entity.Category;
import com.example.crud.springboot_crud_api.model.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
            String name = category.get().getName();
            System.out.println(category.get().getName());
            if (category.isPresent()) {
                product = Product.builder()
                        .id(requestDto.id)
                        .name(requestDto.name)
                        .price(requestDto.price)
                        .category(category.get())
                        .build();
                productRepository.save(product);
//                System.out.println(productRepository.findAll());
                return product;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Product> getProductById(Long id) {
        if (productRepository.existsById(id))
            return productRepository.findById(id);
        return Optional.empty();
    }

//    @PutMapping("/product/{id}")
//    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody CreateProductRequestDto requestDto) {
//        Optional<Product> productById = productRepository.findById(id);
//        if(productById.isPresent()){
//            Product newProduct = productById.get();
//            newProduct.setName(requestDto.name);
//            newProduct.setPrice(requestDto.price);
//            newProduct.
//            return ResponseEntity.ok(updatedProduct.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product or Category not found");
//        }
//    }
}
