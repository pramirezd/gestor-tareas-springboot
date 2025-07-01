package com.pabloramirez.gestortareas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Test", description = "Controlador de prueba para Swagger")
public class SwaggerTestController {

    @GetMapping("/api/hello")
    @Operation(summary = "Saludo de prueba", description = "Endpoint simple para probar Swagger")
    @ApiResponse(responseCode = "200", description = "Saludo exitoso")
    public String hello() {
        return "Hola desde Swagger!";
    }
}