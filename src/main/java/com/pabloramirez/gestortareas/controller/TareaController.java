package com.pabloramirez.gestortareas.controller;

import com.pabloramirez.gestortareas.model.Tarea;
import com.pabloramirez.gestortareas.service.TareaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping(produces = "application/json")
    public List<Tarea> obtenerTareasFiltradas(
            @RequestParam(required = false) Boolean completada,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaAntes,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDespues
    ) {
        return tareaService.buscarPorFiltros(completada, fechaAntes, fechaDespues);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        Tarea tareaActualizada = tareaService.actualizarTarea(id, tarea);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}