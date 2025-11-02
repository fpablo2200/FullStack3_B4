package com.example.clinica.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "RESULTADOS_ANALISIS")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultado;

    private String idExamen;

    @Column(name = "TIPO_ANALISIS", nullable = false, length = 500)
    private String tipoAnalisis;

    private String laboratorio;

    @Column(name = "VALORES_RESULTADO", nullable = false, length = 2000)
    private String valoresResultado;

    private String observaciones;

    @Column(name = "FECHA_RESULTADO", insertable = false, updatable = false)
    private LocalDateTime fechaResultado;

    private String estado;

}
