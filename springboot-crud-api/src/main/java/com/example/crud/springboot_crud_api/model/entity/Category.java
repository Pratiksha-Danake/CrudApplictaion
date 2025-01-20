package com.example.crud.springboot_crud_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(nullable = false, unique = true)
    private String name;


}
