package com.pabloramirez.gestortareas.service;

import com.pabloramirez.gestortareas.model.Tarea;
import com.pabloramirez.gestortareas.repository.TareaRepository;
import com.pabloramirez.gestortareas.exception.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll();
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarea no encontrada con ID: " + id));
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        Tarea tareaExistente = obtenerTareaPorId(id);

        tareaExistente.setTitulo(tareaActualizada.getTitulo());
        tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
        tareaExistente.setFechaVencimiento(tareaActualizada.getFechaVencimiento());
        tareaExistente.setCompletada(tareaActualizada.isCompletada());

        return tareaRepository.save(tareaExistente);
    }

    public void eliminarTarea(Long id) {
        Tarea tarea = obtenerTareaPorId(id);
        tareaRepository.delete(tarea);
    }

    public List<Tarea> buscarPorFiltros(Boolean completada, LocalDate fechaAntes, LocalDate fechaDespues) {
        return tareaRepository.findAll().stream()
                .filter(t -> completada == null || t.isCompletada() == completada)
                .filter(t -> fechaAntes == null || (t.getFechaVencimiento() != null && !t.getFechaVencimiento().isAfter(fechaAntes)))
                .filter(t -> fechaDespues == null || (t.getFechaVencimiento() != null && !t.getFechaVencimiento().isBefore(fechaDespues)))
                .collect(Collectors.toList());
    }
}