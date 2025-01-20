package com.example.crud.springboot_crud_api.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}
