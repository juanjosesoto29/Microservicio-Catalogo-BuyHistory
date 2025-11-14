package com.buyhistory.catalogo_servicio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private Integer id;

    private String name;
    private String description;
    private String category;

    // 💰 Precio FINAL que verá el usuario (se calcula a partir de basePrice + reglas)
    private Integer price;

    private Integer stock;
    private String imageUrl;
    private Boolean discount;

    // 👉 NUEVOS CAMPOS PARA LAS REGLAS DE NEGOCIO

    // Precio base definido por el administrador (antes de aplicar rareza/condición)
    private Integer basePrice;

    // Producto único (antigüedad única)
    private Boolean esUnico;

    // Rareza del producto: COMUN, RARO, LEGENDARIO
    private RarezaProducto rareza;

    // Condición física: EXCELENTE, BUENA, REGULAR
    private CondicionProducto condicion;
}
