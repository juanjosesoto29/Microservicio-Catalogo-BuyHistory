package com.buyhistory.catalogo_servicio.service;

import com.buyhistory.catalogo_servicio.model.Product;

import java.util.List;

public interface ProductService {

    Product crearProducto(Product product);

    Product actualizarProducto(Integer id, Product product);

    List<Product> obtenerTodos();

    Product obtenerPorId(Integer id);

    void eliminar(Integer id);
}
