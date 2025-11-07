package com.buyhistory.catalogo_servicio.web;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Vite
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto one(@PathVariable Long id) {
        return service.findById(id);
    }
}
