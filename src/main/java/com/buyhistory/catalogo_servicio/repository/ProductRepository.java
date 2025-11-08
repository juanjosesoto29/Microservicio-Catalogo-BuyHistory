package com.buyhistory.catalogo_servicio.repository;

import com.buyhistory.catalogo_servicio.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
