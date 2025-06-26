package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IVAController {

    private static final double IVA_PERCENTAGE = 0.19; // 19%

    /**
     * Endpoint para calcular el precio de un artículo con IVA.
     * Ejemplo de uso: GET /iva/calcular?precio=100
     * @param precio El precio base del artículo.
     * @return Un mensaje con el precio final incluyendo el IVA.
     */
    @GetMapping("/iva/calcular")
    public String calcularPrecioConIVA(@RequestParam double precio) {
        double montoIVA = precio * IVA_PERCENTAGE;
        double precioTotal = precio + montoIVA;
        // O más simple: double precioTotal = precio * (1 + IVA_PERCENTAGE);

        return String.format("El precio original es: $%.2f. El precio con 19%% de IVA es: $%.2f", precio, precioTotal);
    }
}