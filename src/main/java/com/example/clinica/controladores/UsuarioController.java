package com.example.clinica.controladores;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dtos.UsuarioDTO;
import com.example.clinica.entidades.Usuarios;
import com.example.clinica.servicios.UsuarioService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuarios> obtenerUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> obtenerUsuariosId(@PathVariable Long id){
        return Optional.ofNullable(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario (@Valid @RequestBody UsuarioDTO usuarioDTO){
        Usuarios usuario = new Usuarios();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setEstado(usuarioDTO.getEstado());

        Usuarios nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }   

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuarios> usuarioExistente = Optional.ofNullable(usuarioService.obtenerUsuarioPorId(id));
        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setCorreo(usuarioDTO.getCorreo());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setRol(usuarioDTO.getRol());
            usuario.setEstado(usuarioDTO.getEstado());

            Usuarios usuarioActualizado = usuarioService.guardarUsuario(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        Optional<Usuarios> usuarioExistente = Optional.ofNullable(usuarioService.obtenerUsuarioPorId(id));
        if (usuarioExistente.isPresent()) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.noContent().build();
        }
    }

}
