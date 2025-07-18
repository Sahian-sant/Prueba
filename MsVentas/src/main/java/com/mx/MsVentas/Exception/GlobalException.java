package com.mx.MsVentas.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<Map<String, Object>> manejarRecursoNoEncontrado(RecursoNoEncontrado ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "Recurso no encontrado");
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("fechaHora", LocalDateTime.now());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarExcepcionGeneral(Exception ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", "Error interno");
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("fechaHora", LocalDateTime.now());
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
