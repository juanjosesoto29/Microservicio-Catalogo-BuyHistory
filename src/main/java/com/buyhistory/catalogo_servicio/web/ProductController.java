package com.buyhistory.catalogo_servicio.web;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // para conectar con tu frontend de React
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
