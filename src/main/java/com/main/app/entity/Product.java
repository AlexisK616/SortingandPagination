package com.main.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
