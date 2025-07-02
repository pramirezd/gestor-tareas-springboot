package com.pabloramirez.gestortareas.repository;

import com.pabloramirez.gestortareas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);

    boolean existsByEmail(String email);
}