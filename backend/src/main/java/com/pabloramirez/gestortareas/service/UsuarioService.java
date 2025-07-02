package com.pabloramirez.gestortareas.service;

import com.pabloramirez.gestortareas.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> buscarPorUsername(String username);
    Usuario guardarUsuario(Usuario usuario);
}