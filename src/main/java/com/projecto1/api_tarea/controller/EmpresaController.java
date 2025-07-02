package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    /**
     * Endpoint para calcular el porcentaje de inversión de cada persona en una empresa.
     * Ejemplo de uso: GET /empresa/porcentaje-inversion?inv1=50000&inv2=30000&inv3=20000
     * @param inv1 Inversión de la persona 1.
     * @param inv2 Inversión de la persona 2.
     * @param inv3 Inversión de la persona 3.
     * @return Una cadena formateada con los porcentajes de inversión.
     */
    @GetMapping("/empresa/porcentaje-inversion")
    public String calcularPorcentajeInversion(
            @RequestParam double inv1,
            @RequestParam double inv2,
            @RequestParam double inv3) {

        StringBuilder sb = new StringBuilder();
        double totalInvertido = inv1 + inv2 + inv3;

        if (totalInvertido == 0) {
            return "No se ha realizado ninguna inversión (total es cero).";
        }

        double porcentaje1 = (inv1 / totalInvertido) * 100;
        double porcentaje2 = (inv2 / totalInvertido) * 100;
        double porcentaje3 = (inv3 / totalInvertido) * 100;

        sb.append(String.format("Inversión total: $%.2f<br>", totalInvertido));
        sb.append(String.format("Porcentaje Persona 1: %.2f%%<br>", porcentaje1));
        sb.append(String.format("Porcentaje Persona 2: %.2f%%<br>", porcentaje2));
        sb.append(String.format("Porcentaje Persona 3: %.2f%%", porcentaje3));

        return sb.toString();
    }
}