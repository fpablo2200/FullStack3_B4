package com.example.clinica.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResultadoDTO {


    @NotBlank(message = "El idExamen no puede estar vacío")
    @Size(min = 1, max = 20, message = "El idExamen debe tener entre 1 y 20 caracteres")
    private String idExamen;

    @NotBlank(message = "El tipoAnalisis no puede estar vacío")
    @Size(min = 1, max = 500, message = "El tipoAnalisis debe tener entre 1 y 500 caracteres")
    private String tipoAnalisis;

    @NotBlank(message = "El laboratorio no puede estar vacío")
    @Size(min = 1, max = 250, message = "El laboratorio debe tener entre 1 y 250 caracteres")
    private String laboratorio;

    @NotBlank(message = "Los valoresResultado no pueden estar vacíos")
    @Size(min = 1, max = 2000, message = "Los valoresResultado deben tener entre 1 y 2000 caracteres")
    private String valoresResultado;

    @Size(max = 500, message = "Las observaciones deben tener máximo 500 caracteres")
    private String observaciones;

    @NotBlank(message = "El estado no puede estar vacio")
    @Size(max = 20, message = "El estado debe tener máximo 20 caracteres")
    private String estado;

}
