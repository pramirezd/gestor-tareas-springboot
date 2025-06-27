package com.pabloramirez.gestortareas.service;

import com.pabloramirez.gestortareas.model.Tarea;
import com.pabloramirez.gestortareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea nuevaTarea) {
        return tareaRepository.findById(id)
                .map(t -> {
                    t.setTitulo(nuevaTarea.getTitulo());
                    t.setDescripcion(nuevaTarea.getDescripcion());
                    t.setFechaVencimiento(nuevaTarea.getFechaVencimiento());
                    t.setCompletada(nuevaTarea.isCompletada());
                    return tareaRepository.save(t);
                })
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
