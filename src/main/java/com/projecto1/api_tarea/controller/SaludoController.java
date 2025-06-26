package com.projecto1.api_tarea.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Para extraer valores de la URL
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta clase es un controlador REST
public class SaludoController {

    // Endpoint 1: GET /saludo
    @GetMapping("/saludo")
    public String obtenerSaludoSimple() {
        return "¡Hola desde Spring Boot!";
    }

    // Endpoint 2: GET /saludo/{nombre}
    // @PathVariable permite extraer el valor de 'nombre' de la URL
    @GetMapping("/saludo/{nombre}")
    public String obtenerSaludoPersonalizado(@PathVariable String nombre) {
        return String.format("¡Hola, %s!", nombre);
    }
}