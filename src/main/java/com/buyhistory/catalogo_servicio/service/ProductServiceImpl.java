package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.model.Product;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private ProductDto map(Product p) {
        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .category(p.getCategory())
                .price(p.getPrice())
                .stock(p.getStock())
                .imageUrl(p.getImageUrl())
                .discount(p.getDiscount())
                .build();
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public ProductDto findById(Integer id) {   // 👈 Integer
        Product p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return map(p);
    }
}
