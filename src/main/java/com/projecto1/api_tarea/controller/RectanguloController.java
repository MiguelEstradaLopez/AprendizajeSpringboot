package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectanguloController {

    /**
     * Endpoint para calcular el área de un rectángulo.
     * Ejemplo de uso: GET /rectangulo/area?largo=10.5&ancho=4.2
     * @param largo La longitud del rectángulo.
     * @param ancho La anchura del rectángulo.
     * @return Un mensaje con el área calculada del rectángulo.
     */
    @GetMapping("/rectangulo/area")
    public String calcularAreaRectangulo(@RequestParam double largo, @RequestParam double ancho) {
        double area = largo * ancho;
        return String.format("El área del rectángulo con largo %.2f y ancho %.2f es: %.2f", largo, ancho, area);
    }
}