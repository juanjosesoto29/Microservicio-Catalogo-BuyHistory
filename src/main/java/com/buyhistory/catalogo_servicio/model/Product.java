package com.buyhistory.catalogo_servicio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data                       // ✅ genera getId(), getName(), etc.
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private Integer id;          // 👈 IMPORTANTE: se llama id

    private String name;
    private String description;
    private String category;
    private Integer price;
    private Integer stock;
    private String imageUrl;
    private Boolean discount;
}
