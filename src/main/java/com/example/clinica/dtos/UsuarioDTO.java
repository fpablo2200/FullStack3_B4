package com.example.clinica.dtos;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 1, max = 100, message = "El apellido debe tener entre 1 y 100 caracteres")
    private String apellido;


    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 1, max = 100, message = "El correo debe tener entre 1 y 100 caracteres")
    @Column(unique = true, nullable = false)
    private String correo;


    @NotBlank(message = "El password no puede estar vacío")
    @Size(min = 6, max = 12, message = "El password debe tener entre 6 y 12 caracteres")
    @Column(name = "password", nullable = false)
    private String password;


    @NotBlank(message = "El rol no puede estar vacío")
    @Size(min = 4, max = 4, message = "El rol debe tener 4 caracteres")
    private String rol;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(min = 1, max = 1, message = "El estado debe tener 1 caracter")
    private String estado;

    

}
