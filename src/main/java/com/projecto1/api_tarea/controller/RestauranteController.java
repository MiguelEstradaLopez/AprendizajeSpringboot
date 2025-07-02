package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController {

    private static final int PRECIO_COMBO1 = 10000;
    private static final int PRECIO_COMBO2 = 7000;
    private static final int PRECIO_COMBO3 = 8000;

    /**
     * Endpoint para calcular el valor total vendido por un restaurante de comidas rápidas.
     * Ejemplo de uso: GET /restaurante/ventas?combo1=5&combo2=3&combo3=2
     * @param combo1 Cantidad de Combo 1 vendidos.
     * @param combo2 Cantidad de Combo 2 vendidos.
     * @param combo3 Cantidad de Combo 3 vendidos.
     * @return Mensaje con el valor total vendido.
     */
    @GetMapping("/restaurante/ventas")
    public String calcularVentasRestaurante(
            @RequestParam int combo1,
            @RequestParam int combo2,
            @RequestParam int combo3) {

        double totalVendido = (combo1 * PRECIO_COMBO1) +
                              (combo2 * PRECIO_COMBO2) +
                              (combo3 * PRECIO_COMBO3);

        return String.format("El valor total vendido por el restaurante es: $%.2f", totalVendido);
    }
}