package com.pabloramirez.gestortareas.repository;

import com.pabloramirez.gestortareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query("SELECT t FROM Tarea t " +
            "WHERE (:completada IS NULL OR t.completada = :completada) " +
            "AND (:fechaAntes IS NULL OR t.fechaVencimiento <= :fechaAntes) " +
            "AND (:fechaDespues IS NULL OR t.fechaVencimiento >= :fechaDespues)")
    List<Tarea> buscarPorFiltros(
            @Param("completada") Boolean completada,
            @Param("fechaAntes") LocalDate fechaAntes,
            @Param("fechaDespues") LocalDate fechaDespues
    );
}