package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto crear(ProductDto dto);

    ProductDto obtenerPorId(Long id);

    List<ProductDto> obtenerTodos();

    ProductDto actualizar(Long id, ProductDto dto);

    void eliminar(Long id);
}
