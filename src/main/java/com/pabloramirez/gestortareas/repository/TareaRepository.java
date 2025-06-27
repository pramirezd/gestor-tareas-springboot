package com.pabloramirez.gestortareas.repository;

import com.pabloramirez.gestortareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Aquí podrías agregar métodos personalizados en el futuro, como:
    // List<Tarea> findByCompletada(boolean completada);
}