package com.example.clinica.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clinica.entidades.Usuarios;
import com.example.clinica.repositorio.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> listarUsuarios() {
        log.debug("Servicio: listarUsuarios()");
        List<Usuarios> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()){
            log.warn("No se encontraron usuarios en la base de datos.");
        }
        return usuarios;
    }
    
    public Usuarios obtenerUsuarioPorId(Long id) {
        log.debug("Servicio: obtenerUsuarioPorId({})", id);

        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            log.warn("Usuario con ID {} no encontrado.", id);
        }
        return usuario.orElse(null);
    }

    public void eliminarUsuario(Long id) {
        log.debug("Servicio: eliminarUsuario({})", id);
        if(!usuarioRepository.existsById(id)) {
            log.warn("No se puede eliminar. Usuario con ID {} no encontrado.", id);
            return;
        }
        usuarioRepository.deleteById(id);
    }
    
    public Usuarios guardarUsuario(Usuarios usuario) {
        log.debug("Servicio: guardarUsuario({})", usuario);
        return usuarioRepository.save(usuario);
    }

    public boolean validarLogin(String correo, String password) {
        return usuarioRepository.findByCorreoAndPassword(correo, password).isPresent();
    }

    public Optional<Usuarios> obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean correoExiste(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }



}
