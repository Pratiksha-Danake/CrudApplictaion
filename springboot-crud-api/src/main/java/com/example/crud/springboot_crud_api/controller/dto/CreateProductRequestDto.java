package com.example.crud.springboot_crud_api.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    public Long id;
    public String name;
    public double price;
    public Long category_id;
}
