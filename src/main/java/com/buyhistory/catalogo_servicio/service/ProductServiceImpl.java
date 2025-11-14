package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.model.Product;
import com.buyhistory.catalogo_servicio.model.RarezaProducto;
import com.buyhistory.catalogo_servicio.model.CondicionProducto;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import com.buyhistory.catalogo_servicio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // ===========================
    // CRUD + reglas de negocio
    // ===========================

    @Override
    public Product crearProducto(Product product) {
        aplicarLogicaNegocio(product);
        return productRepository.save(product);
    }

    @Override
    public Product actualizarProducto(Integer id, Product actualizado) {
        Product existente = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setName(actualizado.getName());
        existente.setDescription(actualizado.getDescription());
        existente.setCategory(actualizado.getCategory());
        existente.setBasePrice(actualizado.getBasePrice());
        existente.setStock(actualizado.getStock());
        existente.setImageUrl(actualizado.getImageUrl());
        existente.setDiscount(actualizado.getDiscount());
        existente.setEsUnico(actualizado.getEsUnico());
        existente.setRareza(actualizado.getRareza());
        existente.setCondicion(actualizado.getCondicion());

        aplicarLogicaNegocio(existente);

        return productRepository.save(existente);
    }

    @Override
    public Product obtenerPorId(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public List<Product> obtenerTodos() {
        return productRepository.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        productRepository.deleteById(id);
    }


    // ===========================
    //  REGLAS DE NEGOCIO
    // ===========================

    private void aplicarLogicaNegocio(Product p) {
        validarProductoUnico(p);
        aplicarReglasRareza(p);
        calcularPrecioFinal(p);
    }

    // 1️⃣ PRODUCTOS ÚNICOS → stock = 1
    private void validarProductoUnico(Product p) {
        if (Boolean.TRUE.equals(p.getEsUnico()) &&
            p.getStock() != null &&
            p.getStock() > 1) {

            throw new IllegalArgumentException(
                "Los productos marcados como ÚNICOS no pueden tener más de 1 unidad en stock."
            );
        }
    }

    // 2️⃣ RAREZA → reglas específicas
    private void aplicarReglasRareza(Product p) {
        if (p.getRareza() == null) return;

        switch (p.getRareza()) {
            case COMUN -> { }

            case RARO -> {
                if (p.getStock() != null && p.getStock() > 5) {
                    throw new IllegalArgumentException(
                        "Los productos RAROS no pueden tener más de 5 unidades."
                    );
                }
            }

            case LEGENDARIO -> {
                p.setEsUnico(true);
                p.setStock(1);
            }
        }
    }

    // 3️⃣ PRECIOS DINÁMICOS (condición + rareza)
    private void calcularPrecioFinal(Product p) {

        if (p.getBasePrice() == null) {
            throw new IllegalArgumentException("basePrice es obligatorio.");
        }

        int base = p.getBasePrice();

        double factorCondicion = switch (p.getCondicion()) {
            case EXCELENTE -> 1.10;
            case BUENA     -> 1.00;
            case REGULAR   -> 0.90;
        };

        double factorRareza = switch (p.getRareza()) {
            case COMUN      -> 1.00;
            case RARO       -> 1.20;
            case LEGENDARIO -> 1.50;
        };

        int precioFinal = (int) Math.round(base * factorCondicion * factorRareza);
        p.setPrice(precioFinal);
    }

}
