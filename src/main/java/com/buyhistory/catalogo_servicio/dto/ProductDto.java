package com.buyhistory.catalogo_servicio.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;            // ojo: ahora Long (igual que la entidad)

    private String name;
    private String description;
    private String category;
    private Integer price;
    private Integer stock;
    private String imageUrl;
    private Boolean discount;

    // 🔹 Campos de negocio
    private String rarity;
   // COMUN / RARO / UNICO
    private String condition;   // EXCELENTE / BUENO / REGULAR / etc.
}
