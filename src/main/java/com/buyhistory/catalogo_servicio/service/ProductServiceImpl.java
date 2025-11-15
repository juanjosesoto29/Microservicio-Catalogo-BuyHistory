package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.model.Product;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    // ---------- CRUD ----------

    @Override
    public ProductDto crear(ProductDto dto) {
        Product entity = toEntity(dto);
        aplicarReglasDeNegocio(entity);
        Product saved = repo.save(entity);
        return toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto obtenerPorId(Long id) {
        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
        return toDto(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> obtenerTodos() {
        return repo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProductDto actualizar(Long id, ProductDto dto) {
        Product existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));

        existente.setName(dto.getName());
        existente.setDescription(dto.getDescription());
        existente.setCategory(dto.getCategory());
        existente.setPrice(dto.getPrice());
        existente.setStock(dto.getStock());
        existente.setImageUrl(dto.getImageUrl());
        existente.setDiscount(
                dto.getDiscount() != null ? dto.getDiscount() : Boolean.FALSE
        );
        existente.setRarity(dto.getRarity());
        existente.setCondition(dto.getCondition());

        aplicarReglasDeNegocio(existente);

        Product guardado = repo.save(existente);
        return toDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Producto no encontrado: " + id);
        }
        repo.deleteById(id);
    }

    // ---------- Reglas de negocio ----------

    private void aplicarReglasDeNegocio(Product p) {
        String rarity = p.getRarity();
        String condition = p.getCondition();

        if (rarity != null) rarity = rarity.trim().toUpperCase();
        if (condition != null) condition = condition.trim().toUpperCase();

        int price = p.getPrice() != null ? p.getPrice() : 0;
        int stock = p.getStock() != null ? p.getStock() : 0;

        // 1) Rareza
        if (rarity == null || rarity.isBlank()) {
            if (price >= 200_000 || stock <= 1) {
                rarity = "UNICO";
            } else if (price >= 80_000 || stock <= 5) {
                rarity = "RARO";
            } else {
                rarity = "COMUN";
            }
        }

        // 2) Condición
        if (condition == null || condition.isBlank()) {
            if (price >= 150_000) {
                condition = "EXCELENTE";
            } else if (price >= 60_000) {
                condition = "BUENO";
            } else {
                condition = "REGULAR";
            }
        }

        // 3) Si es único, stock = 1
        if ("UNICO".equals(rarity)) {
            stock = 1;
        }

        // 4) Si discount es null, poner false
        if (p.getDiscount() == null) {
            p.setDiscount(Boolean.FALSE);
        }

        p.setRarity(rarity);
        p.setCondition(condition);
        p.setStock(stock);
    }

    // ---------- Mapeos DTO <-> Entidad ----------

    private ProductDto toDto(Product p) {
        if (p == null) return null;

        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .category(p.getCategory())
                .price(p.getPrice())
                .stock(p.getStock())
                .imageUrl(p.getImageUrl())
                .discount(p.getDiscount())
                .rarity(p.getRarity())
                .condition(p.getCondition())
                .build();
    }

    private Product toEntity(ProductDto dto) {
        if (dto == null) return null;

        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .imageUrl(dto.getImageUrl())
                .discount(dto.getDiscount() != null ? dto.getDiscount() : Boolean.FALSE)
                .rarity(dto.getRarity())
                .condition(dto.getCondition())
                .build();
    }
}
