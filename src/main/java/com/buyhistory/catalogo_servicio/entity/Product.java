package com.buyhistory.catalogo_servicio.entity;

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

    @Column(length = 1000)
    private String description;

    private String category;

    private Double price;

    private Integer stock;

    @Column(name = "image_url")
    private String imageUrl;

    private Boolean discount;
}
