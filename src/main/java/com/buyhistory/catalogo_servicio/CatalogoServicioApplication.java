package com.buyhistory.catalogo_servicio;

import com.buyhistory.catalogo_servicio.model.Product;
import com.buyhistory.catalogo_servicio.model.RarezaProducto;
import com.buyhistory.catalogo_servicio.model.CondicionProducto;
import com.buyhistory.catalogo_servicio.repository.ProductRepository;
import com.buyhistory.catalogo_servicio.service.ProductService;
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
    CommandLineRunner initProducts(ProductRepository repo, ProductService productService) {
        return args -> {
            // Para evitar duplicados: solo insertamos si la colección está vacía
            if (repo.count() == 0) {

                List<Product> products = List.of(
                    Product.builder()
                        .id(101)
                        .name("Sombrero de Napoleón")
                        .description("Sombrero original del general. Ideal para cualquier ocasión.")
                        .category("Histórico")
                        .basePrice(120000)              // precio base
                        .stock(1)                       // legendario y único → 1
                        .imageUrl("/imgs/sombrero-napoleon.webp")
                        .discount(true)
                        .esUnico(true)
                        .rareza(RarezaProducto.LEGENDARIO)
                        .condicion(CondicionProducto.EXCELENTE)
                        .build(),

                    Product.builder()
                        .id(102)
                        .name("Máscara Egipcia")
                        .description("Máscara funeraria dorada de época faraónica.")
                        .category("Antigüedades")
                        .basePrice(80000)
                        .stock(5)                       // RARO → máx 5
                        .imageUrl("/imgs/mascara-egipcia.jpg")
                        .discount(false)
                        .esUnico(false)
                        .rareza(RarezaProducto.RARO)
                        .condicion(CondicionProducto.BUENA)
                        .build(),

                    Product.builder()
                        .id(103)
                        .name("Moneda Romana")
                        .description("Antigua moneda de plata romana, conservada en buen estado.")
                        .category("Numismática")
                        .basePrice(50000)
                        .stock(24)
                        .imageUrl("/imgs/moneda-romana.png")
                        .discount(false)
                        .esUnico(false)
                        .rareza(RarezaProducto.COMUN)
                        .condicion(CondicionProducto.BUENA)
                        .build(),

                    Product.builder()
                        .id(104)
                        .name("Macuquinas")
                        .description("Moneda de oro macuquina de época colonial.")
                        .category("Numismática")
                        .basePrice(100000)
                        .stock(3)                       // RARO → máx 5
                        .imageUrl("/imgs/macuquinas.jpg")
                        .discount(true)
                        .esUnico(false)
                        .rareza(RarezaProducto.RARO)
                        .condicion(CondicionProducto.EXCELENTE)
                        .build(),

                    Product.builder()
                        .id(105)
                        .name("Serpiente azteca de dos cabezas")
                        .description("Figura ceremonial azteca con doble cabeza, símbolo de poder.")
                        .category("Arte Precolombino")
                        .basePrice(250000)
                        .stock(1)                       // legendario y único
                        .imageUrl("/imgs/serpiente-azteca.jpg")
                        .discount(true)
                        .esUnico(true)
                        .rareza(RarezaProducto.LEGENDARIO)
                        .condicion(CondicionProducto.EXCELENTE)
                        .build(),

                    Product.builder()
                        .id(106)
                        .name("El penique de Maine")
                        .description("Pieza histórica de Estados Unidos, raro ejemplar coleccionable.")
                        .category("Numismática")
                        .basePrice(40000)
                        .stock(10)
                        .imageUrl("/imgs/penique-maine.jpg")
                        .discount(false)
                        .esUnico(false)
                        .rareza(RarezaProducto.COMUN)
                        .condicion(CondicionProducto.REGULAR)
                        .build(),

                    Product.builder()
                        .id(107)
                        .name("Calendario Maya")
                        .description("Calendario precolombino, perfectamente conservado.")
                        .category("Arte Precolombino")
                        .basePrice(170000)
                        .stock(5)                       // RARO → máx 5
                        .imageUrl("/imgs/calendario-maya.jpg")
                        .discount(false)
                        .esUnico(false)
                        .rareza(RarezaProducto.RARO)
                        .condicion(CondicionProducto.EXCELENTE)
                        .build(),

                    Product.builder()
                        .id(108)
                        .name("Máscara de Agamenón")
                        .description("Máscara funeraria griega, de oro macizo.")
                        .category("Antigüedades")
                        .basePrice(350000)
                        .stock(1)                       // legendario y único
                        .imageUrl("/imgs/mascara-agamenon.jpg")
                        .discount(false)
                        .esUnico(true)
                        .rareza(RarezaProducto.LEGENDARIO)
                        .condicion(CondicionProducto.EXCELENTE)
                        .build()
                );

                // Usamos el service para que se apliquen las reglas de negocio
                products.forEach(productService::crearProducto);

                System.out.println("✅ Productos iniciales cargados en MongoDB con lógica de negocio aplicada.");
            } else {
                System.out.println("ℹ️ Colección 'products' ya tiene datos, no se carga seed.");
            }
        };
    }
}
