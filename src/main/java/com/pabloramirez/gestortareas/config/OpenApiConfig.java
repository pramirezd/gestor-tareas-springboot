package com.pabloramirez.gestortareas.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestor de Tareas API")
                        .version("1.0")
                        .description("API para gestionar tareas personales")
                        .contact(new Contact()
                                .name("Pablo Ramírez")
                                .url("https://github.com/pramirezd")
                        )
                );
    }
}