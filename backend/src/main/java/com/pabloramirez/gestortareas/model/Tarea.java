package com.pabloramirez.gestortareas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Schema(description = "Entidad que representa una tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la tarea", example = "1")
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    @Schema(description = "Título de la tarea", example = "Completar proyecto", maxLength = 100)
    private String titulo;

    @NotNull(message = "La descripción no puede ser nula")
    @Size(min = 1, max = 250, message = "La descripción debe tener entre 1 y 250 caracteres")
    @Schema(description = "Descripción detallada de la tarea", example = "Finalizar el desarrollo del módulo de usuarios", minLength = 1, maxLength = 250)
    private String descripcion;

    // Removemos @Future temporalmente para que funcione Swagger
    // @Future(message = "La fecha de vencimiento debe ser futura")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de vencimiento de la tarea", example = "2025-12-31", type = "string", format = "date")
    private LocalDate fechaVencimiento;

    @Schema(description = "Indica si la tarea está completada", example = "false")
    private boolean completada;

    public Tarea() {}

    public Tarea(String titulo, String descripcion, LocalDate fechaVencimiento, boolean completada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.completada = completada;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
}