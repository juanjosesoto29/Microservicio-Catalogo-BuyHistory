package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Integer id);
}
