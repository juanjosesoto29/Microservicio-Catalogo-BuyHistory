package com.buyhistory.catalogo_servicio;

import com.buyhistory.catalogo_servicio.dto.ProductDto;
import com.buyhistory.catalogo_servicio.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogoServicioApplication.class, args);
    }

    @Bean
    CommandLineRunner initProducts(ProductService productService) {
        return args -> {

            // Si ya hay productos, no volvemos a sembrar
            if (!productService.obtenerTodos().isEmpty()) {
                System.out.println("ℹ️ Ya existen productos en la BD, no se carga seed.");
                return;
            }

            System.out.println("🚀 Sembrando productos iniciales para BuyHistory...");

            productService.crear(ProductDto.builder()
                    .name("Sombrero de Napoleón")
                    .description("Sombrero original del general. Ideal para cualquier ocasión.")
                    .category("Histórico")
                    .price(120000)
                    .stock(1)
                    .imageUrl("/imgs/sombrero-napoleon.webp")
                    .discount(true)
                    .rarity("UNICO")
                    .condition("EXCELENTE")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Máscara Egipcia")
                    .description("Máscara funeraria dorada de época faraónica.")
                    .category("Antigüedades")
                    .price(80000)
                    .stock(3)
                    .imageUrl("/imgs/mascara-egipcia.jpg")
                    .discount(false)
                    .rarity("RARO")
                    .condition("EXCELENTE")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Moneda Romana")
                    .description("Antigua moneda de plata romana, conservada en buen estado.")
                    .category("Numismática")
                    .price(50000)
                    .stock(24)
                    .imageUrl("/imgs/moneda-romana.png")
                    .discount(false)
                    .rarity("RARO")
                    .condition("BUENO")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Macuquinas")
                    .description("Moneda de oro macuquina de época colonial.")
                    .category("Numismática")
                    .price(100000)
                    .stock(10)
                    .imageUrl("/imgs/macuquinas.jpg")
                    .discount(true)
                    .rarity("RARO")
                    .condition("EXCELENTE")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Serpiente azteca de dos cabezas")
                    .description("Figura ceremonial azteca con doble cabeza, símbolo de poder.")
                    .category("Arte Precolombino")
                    .price(250000)
                    .stock(1)
                    .imageUrl("/imgs/serpiente-azteca.jpg")
                    .discount(true)
                    .rarity("UNICO")
                    .condition("EXCELENTE")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("El penique de Maine")
                    .description("Pieza histórica de Estados Unidos, raro ejemplar coleccionable.")
                    .category("Numismática")
                    .price(40000)
                    .stock(10)
                    .imageUrl("/imgs/penique-maine.jpg")
                    .discount(false)
                    .rarity("RARO")
                    .condition("BUENO")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Calendario Maya")
                    .description("Calendario precolombino, perfectamente conservado.")
                    .category("Arte Precolombino")
                    .price(170000)
                    .stock(8)
                    .imageUrl("/imgs/calendario-maya.jpg")
                    .discount(false)
                    .rarity("RARO")
                    .condition("REGULAR")
                    .build()
            );

            productService.crear(ProductDto.builder()
                    .name("Máscara de Agamenón")
                    .description("Máscara funeraria griega, de oro macizo.")
                    .category("Antigüedades")
                    .price(350000)
                    .stock(1)
                    .imageUrl("/imgs/mascara-agamenon.jpg")
                    .discount(false)
                    .rarity("UNICO")
                    .condition("BUENO")
                    .build()
            );

            System.out.println("✅ Productos iniciales creados con reglas de negocio aplicadas.");
        };
    }
}
