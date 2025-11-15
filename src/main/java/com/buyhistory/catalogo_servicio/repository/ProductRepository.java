package com.buyhistory.catalogo_servicio.repository;

import com.buyhistory.catalogo_servicio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
