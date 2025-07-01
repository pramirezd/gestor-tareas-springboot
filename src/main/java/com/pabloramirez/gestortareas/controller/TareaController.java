package com.pabloramirez.gestortareas.controller;

import com.pabloramirez.gestortareas.model.Tarea;
import com.pabloramirez.gestortareas.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@Tag(name = "Tareas", description = "API para gestión de tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Obtener tareas filtradas", description = "Obtiene una lista de tareas con filtros opcionales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida exitosamente")
    })
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Tarea> obtenerTareasFiltradas(
            @Parameter(description = "Filtrar por estado de completado")
            @RequestParam(required = false) Boolean completada,
            @Parameter(description = "Filtrar tareas creadas antes de esta fecha")
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaAntes,
            @Parameter(description = "Filtrar tareas creadas después de esta fecha")
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDespues
    ) {
        return tareaService.buscarPorFiltros(completada, fechaAntes, fechaDespues);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Obtener tarea por ID", description = "Obtiene una tarea específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea encontrada"),
            @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Tarea> obtenerTareaPorId(
            @Parameter(description = "ID de la tarea", required = true)
            @PathVariable Long id) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping(produces = "application/json")
    @Operation(summary = "Crear nueva tarea", description = "Crea una nueva tarea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarea creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de tarea inválidos")
    })
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tarea> crearTarea(@Valid @RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Actualizar tarea", description = "Actualiza una tarea existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Tarea no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos de tarea inválidos")
    })
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tarea> actualizarTarea(
            @Parameter(description = "ID de la tarea", required = true)
            @PathVariable Long id,
            @Valid @RequestBody Tarea tarea) {
        Tarea tareaActualizada = tareaService.actualizarTarea(id, tarea);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Eliminar tarea", description = "Elimina una tarea por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tarea eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminarTarea(
            @Parameter(description = "ID de la tarea", required = true)
            @PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}