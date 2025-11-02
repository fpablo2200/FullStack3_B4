package com.example.clinica.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clinica.entidades.Resultado;
import com.example.clinica.repositorio.ResultadoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResultadoService {

        @Autowired
    private ResultadoRepository resultadoRepository;

    public List<Resultado> listarResultados() {
        log.debug("Servicio: listarResultados()");
        List<Resultado> resultados = resultadoRepository.findAll();
        if(resultados.isEmpty()){
            log.warn("No se encontraron resultados en la base de datos.");
        }
        return resultados;
    }

    public Resultado obtenerResultadoPorId(Long id) {
        log.debug("Servicio: obtenerResultadoPorId({})", id);

        Optional<Resultado> resultado = resultadoRepository.findById(id);
        if (resultado.isEmpty()) {
            log.warn("Resultado con ID {} no encontrado.", id);
        }
        return resultado.orElse(null);
    }

    public Resultado guardarResultado(Resultado resultado) {
        log.debug("Servicio: guardarResultado({})", resultado);
        return resultadoRepository.save(resultado);
    }


    public void eliminarResultado(Long id) {
        log.debug("Servicio: eliminarResultado({})", id);
        if(!resultadoRepository.existsById(id)) {
            log.warn("No se puede eliminar. Resultado con ID {} no encontrado.", id);
            return;
        }   
        resultadoRepository.deleteById(id);
    }

    
}
