package com.example.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResultadoException extends RuntimeException {

    public ResultadoException(Long id){
        super("No existe el resultado con id: "+ id);
    }

}
