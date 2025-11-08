package com.buyhistory.catalogo_servicio;

import com.buyhistory.catalogo_servicio.model.Product;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CatalogoServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogoServicioApplication.class, args);
    }

    @Bean
    CommandLineRunner initProducts(ProductRepository repo) {
        return args -> {
            // Para evitar duplicados: solo insertamos si la colección está vacía
            if (repo.count() == 0) {
                repo.saveAll(List.of(
                    new Product(
                        101,
                        "Sombrero de Napoleón",
                        "Sombrero original del general. Ideal para cualquier ocasión.",
                        "Histórico",
                        120000,
                        10,
                        "/imgs/sombrero-napoleon.webp",
                        true
                    ),
                    new Product(
                        102,
                        "Máscara Egipcia",
                        "Máscara funeraria dorada de época faraónica.",
                        "Antigüedades",
                        80000,
                        10,
                        "/imgs/mascara-egipcia.jpg",
                        false
                    ),
                    new Product(
                        103,
                        "Moneda Romana",
                        "Antigua moneda de plata romana, conservada en buen estado.",
                        "Numismática",
                        50000,
                        24,
                        "/imgs/moneda-romana.png",
                        false
                    ),
                    new Product(
                        104,
                        "Macuquinas",
                        "Moneda de oro macuquina de época colonial.",
                        "Numismática",
                        100000,
                        34,
                        "/imgs/macuquinas.jpg",
                        true
                    ),
                    new Product(
                        105,
                        "Serpiente azteca de dos cabezas",
                        "Figura ceremonial azteca con doble cabeza, símbolo de poder.",
                        "Arte Precolombino",
                        250000,
                        2,
                        "/imgs/serpiente-azteca.jpg",
                        true
                    ),
                    new Product(
                        106,
                        "El penique de Maine",
                        "Pieza histórica de Estados Unidos, raro ejemplar coleccionable.",
                        "Numismática",
                        40000,
                        10,
                        "/imgs/penique-maine.jpg",
                        false
                    ),
                    new Product(
                        107,
                        "Calendario Maya",
                        "Calendario precolombino, perfectamente conservado.",
                        "Arte Precolombino",
                        170000,
                        8,
                        "/imgs/calendario-maya.jpg",
                        false
                    ),
                    new Product(
                        108,
                        "Máscara de Agamenón",
                        "Máscara funeraria griega, de oro macizo.",
                        "Antigüedades",
                        350000,
                        10,
                        "/imgs/mascara-agamenon.jpg",
                        false
                    )
                ));

                System.out.println("✅ Productos iniciales cargados en MongoDB.");
            } else {
                System.out.println("ℹ️ Colección 'products' ya tiene datos, no se carga seed.");
            }
        };
    }
}
