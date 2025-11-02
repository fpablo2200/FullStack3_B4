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

import com.example.clinica.dtos.ResultadoDTO;
import com.example.clinica.entidades.Resultado;
import com.example.clinica.servicios.ResultadoService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public List<Resultado> obtenerResultados() {
        return resultadoService.listarResultados();
    }

    @GetMapping("/{id}")
    public Optional<Resultado> obtenerResultadoPorId(@PathVariable Long id) {
        return Optional.ofNullable(resultadoService.obtenerResultadoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Resultado> crearResultado(@Valid @RequestBody ResultadoDTO resultadodto) {

        log.debug("Creando nuevo resultado con los datos: {}", resultadodto);
        Resultado resultado = new Resultado();
        resultado.setIdExamen(resultadodto.getIdExamen());
        resultado.setTipoAnalisis(resultadodto.getTipoAnalisis());
        resultado.setLaboratorio(resultadodto.getLaboratorio());
        resultado.setValoresResultado(resultadodto.getValoresResultado());
        resultado.setObservaciones(resultadodto.getObservaciones());
        resultado.setEstado(resultadodto.getEstado());
        Resultado nuevoResultado = resultadoService.guardarResultado(resultado);
        return ResponseEntity.ok(nuevoResultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> actualizarResultado(@PathVariable Long id, @Valid @RequestBody ResultadoDTO resultadoDTO) {
        Optional<Resultado> resultadoExistente = Optional.ofNullable(resultadoService.obtenerResultadoPorId(id));
        if (resultadoExistente.isPresent()) {
            Resultado resultado = resultadoExistente.get();
            resultado.setIdExamen(resultadoDTO.getIdExamen());
            resultado.setTipoAnalisis(resultadoDTO.getTipoAnalisis());
            resultado.setLaboratorio(resultadoDTO.getLaboratorio());
            resultado.setValoresResultado(resultadoDTO.getValoresResultado());
            resultado.setObservaciones(resultadoDTO.getObservaciones());
            resultado.setEstado(resultadoDTO.getEstado());
            Resultado resultadoActualizado = resultadoService.guardarResultado(resultado);
            return ResponseEntity.ok(resultadoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResultado(@PathVariable Long id) {
        Optional<Resultado> resultadoExistente = Optional.ofNullable(resultadoService.obtenerResultadoPorId(id));
        if (resultadoExistente.isPresent()) {
            resultadoService.eliminarResultado(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
