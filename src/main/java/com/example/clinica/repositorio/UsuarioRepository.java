package com.example.clinica.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clinica.entidades.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

}
