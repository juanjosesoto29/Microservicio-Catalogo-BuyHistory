package com.buyhistory.catalogo_servicio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500)
    private String description;

    private String category;

    private Integer price;

    private Integer stock;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private Boolean discount;

    private String rarity;

    // "condition" es palabra reservada en SQL, mejor renombrar la columna
    @Column(name = "product_condition")
    private String condition;
}
