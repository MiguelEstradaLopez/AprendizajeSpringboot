package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotasController {

    private static final double PORCENTAJE_PARCIAL = 0.20;
    private static final double PORCENTAJE_FINAL = 0.20;
    private static final double PORCENTAJE_SEGUIMIENTO = 0.60;

    /**
     * Endpoint para calcular la nota definitiva de una asignatura.
     * Ejemplo de uso: GET /notas/definitiva?parcial=3.5&final=4.0&seguimiento=4.8
     * @param parcial Nota del examen parcial.
     * @param fin Nota del examen final.
     * @param seguimiento Nota del seguimiento.
     * @return Mensaje con la nota definitiva.
     */
    @GetMapping("/notas/definitiva")
    public String calcularNotaDefinitiva(
            @RequestParam double parcial,
            @RequestParam double fin,
            @RequestParam double seguimiento) {

        // Validaciones básicas de notas
        if (parcial < 0 || parcial > 5 || fin < 0 || fin > 5 || seguimiento < 0 || seguimiento > 5) {
            return "Error: Las notas deben estar en el rango de 0 a 5.";
        }

        double notaDefinitiva = (parcial * PORCENTAJE_PARCIAL) +
                                (fin * PORCENTAJE_FINAL) +
                                (seguimiento * PORCENTAJE_SEGUIMIENTO);

        return String.format("La nota definitiva del estudiante es: %.2f", notaDefinitiva);
    }
}