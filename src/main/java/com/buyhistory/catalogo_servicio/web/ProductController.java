package com.buyhistory.catalogo_servicio.web;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> listar() {
        return productService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ProductDto obtener(@PathVariable Long id) {
        return productService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto crear(@RequestBody ProductDto dto) {
        return productService.crear(dto);
    }

    @PutMapping("/{id}")
    public ProductDto actualizar(@PathVariable Long id, @RequestBody ProductDto dto) {
        return productService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productService.eliminar(id);
    }
}
