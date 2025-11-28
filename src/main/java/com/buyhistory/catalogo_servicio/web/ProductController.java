package com.buyhistory.catalogo_servicio.web;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Tag(
        name = "Productos",
        description = "Operaciones CRUD del catálogo de productos de BuyHistory"
)
public class ProductController {

    private final ProductService productService;

    // ===========================
    // Listar todos los productos
    // ===========================

    @Operation(
            summary = "Listar productos",
            description = "Obtiene el listado completo de productos disponibles en el catálogo."
    )
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public List<ProductDto> listar() {
        return productService.obtenerTodos();
    }

    // ===========================
    // Obtener producto por ID
    // ===========================

    @Operation(
            summary = "Obtener producto por ID",
            description = "Busca un producto específico utilizando su identificador único."
    )
    @ApiResponse(responseCode = "200", description = "Producto encontrado")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping("/{id}")
    public ProductDto obtener(@PathVariable Long id) {
        return productService.obtenerPorId(id);
    }

    // ===========================
    // Crear producto
    // ===========================

    @Operation(
            summary = "Crear producto",
            description = "Crea un nuevo producto en el catálogo."
    )
    @ApiResponse(responseCode = "201", description = "Producto creado correctamente")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto crear(@RequestBody ProductDto dto) {
        return productService.crear(dto);
    }

    // ===========================
    // Actualizar producto
    // ===========================

    @Operation(
            summary = "Actualizar producto",
            description = "Actualiza los datos de un producto existente."
    )
    @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente")
    @PutMapping("/{id}")
    public ProductDto actualizar(@PathVariable Long id, @RequestBody ProductDto dto) {
        return productService.actualizar(id, dto);
    }

    // ===========================
    // Eliminar producto
    // ===========================

    @Operation(
            summary = "Eliminar producto",
            description = "Elimina un producto del catálogo."
    )
    @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productService.eliminar(id);
    }
}
