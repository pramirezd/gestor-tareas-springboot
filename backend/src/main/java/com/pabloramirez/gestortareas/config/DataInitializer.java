package com.pabloramirez.gestortareas.config;

import com.pabloramirez.gestortareas.model.Usuario;
import com.pabloramirez.gestortareas.model.enums.Rol;
import com.pabloramirez.gestortareas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findAll().isEmpty()) {
            Usuario admin = Usuario.builder()
                    .username("admin")
                    .nombre("Administrador")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("admin123"))
                    .rol(Rol.ADMIN)
                    .build();

            Usuario user = Usuario.builder()
                    .username("user")
                    .nombre("Usuario Regular")
                    .email("user@example.com")
                    .password(passwordEncoder.encode("user123"))
                    .rol(Rol.USER)
                    .build();

            usuarioRepository.save(admin);
            usuarioRepository.save(user);

            System.out.println("✅ Usuarios de prueba creados correctamente.");
        } else {
            System.out.println("ℹ️  Ya existen usuarios registrados. No se crearán nuevos.");
        }
    }
}