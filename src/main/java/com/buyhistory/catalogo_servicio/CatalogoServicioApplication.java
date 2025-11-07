package com.buyhistory.catalogo_servicio;

import com.buyhistory.catalogo_servicio.entity.Product;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogoServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogoServicioApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(ProductRepository repository) {
        return args -> {

            if (repository.count() > 0) {
                return; // ya hay datos, no volver a insertar
            }

            repository.save(Product.builder()
                    .name("Sombrero de Napoleón")
                    .description("Sombrero original del general. Ideal para cualquier ocasión.")
                    .category("Histórico")
                    .price(120000.0)
                    .stock(10)
                    .imageUrl("/imgs/sombrero-napoleon.webp")
                    .discount(true)
                    .build());

            repository.save(Product.builder()
                    .name("Máscara Egipcia")
                    .description("Máscara funeraria dorada de época faraónica.")
                    .category("Antigüedades")
                    .price(80000.0)
                    .stock(10)
                    .imageUrl("/imgs/mascara-egipcia.jpg")
                    .discount(false)
                    .build());

            repository.save(Product.builder()
                    .name("Moneda Romana")
                    .description("Antigua moneda de plata romana, conservada en buen estado.")
                    .category("Numismática")
                    .price(50000.0)
                    .stock(24)
                    .imageUrl("/imgs/moneda-romana.png")
                    .discount(false)
                    .build());

            repository.save(Product.builder()
                    .name("Macuquinas")
                    .description("Moneda de oro macuquina de época colonial.")
                    .category("Numismática")
                    .price(100000.0)
                    .stock(34)
                    .imageUrl("/imgs/macuquinas.jpg")
                    .discount(true)
                    .build());

            repository.save(Product.builder()
                    .name("Serpiente azteca de dos cabezas")
                    .description("Figura ceremonial azteca con doble cabeza, símbolo de poder.")
                    .category("Arte Precolombino")
                    .price(250000.0)
                    .stock(2)
                    .imageUrl("/imgs/serpiente-azteca.jpg")
                    .discount(true)
                    .build());

            repository.save(Product.builder()
                    .name("El penique de Maine")
                    .description("Pieza histórica de Estados Unidos, raro ejemplar coleccionable.")
                    .category("Numismática")
                    .price(40000.0)
                    .stock(10)
                    .imageUrl("/imgs/penique-maine.jpg")
                    .discount(false)
                    .build());

            repository.save(Product.builder()
                    .name("Calendario Maya")
                    .description("Calendario precolombino, perfectamente conservado.")
                    .category("Arte Precolombino")
                    .price(170000.0)
                    .stock(8)
                    .imageUrl("/imgs/calendario-maya.jpg")
                    .discount(false)
                    .build());

            repository.save(Product.builder()
                    .name("Máscara de Agamenón")
                    .description("Máscara funeraria griega, de oro macizo.")
                    .category("Antigüedades")
                    .price(350000.0)
                    .stock(10)
                    .imageUrl("/imgs/mascara-agamenon.jpg")
                    .discount(false)
                    .build());
        };
    }
}
