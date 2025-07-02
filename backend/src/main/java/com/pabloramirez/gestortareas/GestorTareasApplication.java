package com.pabloramirez.gestortareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestor de Tareas API",
                version = "1.0",
                description = "Documentación de la API REST para gestionar tareas"
        )
)
@SpringBootApplication
public class GestorTareasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorTareasApplication.class, args);
    }
}