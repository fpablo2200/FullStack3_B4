package com.example.clinica.repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clinica.entidades.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByCorreo(String correo);
    Optional<Usuarios> findByCorreoAndPassword(String correo, String password);
    boolean existsByCorreo(String correo);

}
