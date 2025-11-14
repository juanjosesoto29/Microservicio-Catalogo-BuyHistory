package com.buyhistory.catalogo_servicio.dto;

import com.buyhistory.catalogo_servicio.model.RarezaProducto;
import com.buyhistory.catalogo_servicio.model.CondicionProducto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private String category;

    // Precio final calculado por las reglas de negocio
    private Integer price;

    private Integer stock;
    private String imageUrl;
    private Boolean discount;

    // Precio base antes de aplicar rareza + condición
    private Integer basePrice;

    // Producto único (stock forzado a 1)
    private Boolean esUnico;

    // Rareza => COMUN, RARO, LEGENDARIO
    private RarezaProducto rareza;

    // Condición => EXCELENTE, BUENA, REGULAR
    private CondicionProducto condicion;
}
