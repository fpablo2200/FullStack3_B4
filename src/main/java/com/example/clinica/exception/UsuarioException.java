package com.example.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioException  extends RuntimeException {

    public UsuarioException(Long id){
        super("No existe el usuario con id: "+ id);
    }
}
