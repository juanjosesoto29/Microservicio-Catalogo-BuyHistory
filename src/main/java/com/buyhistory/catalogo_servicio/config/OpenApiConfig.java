package com.buyhistory.catalogo_servicio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI catalogoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BuyHistory - API de Catálogo de Productos")
                        .description("Microservicio de catálogo de productos de la tienda BuyHistory.")
                        .version("v1.0"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor local - Catálogo (8080)")
                ));
    }
}
