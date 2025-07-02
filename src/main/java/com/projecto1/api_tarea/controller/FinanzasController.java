package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanzasController {

    /**
     * Endpoint para calcular el interés ganado sobre una inversión.
     * Ejemplo de uso: GET /finanzas/calcular-interes?monto=1000&interes=5
     * @param monto El monto de la inversión inicial.
     * @param interes El porcentaje de interés (ej. 5 para 5%).
     * @return Mensaje con el valor del interés ganado.
     */
    @GetMapping("/finanzas/calcular-interes")
    public String calcularInteres(@RequestParam double monto, @RequestParam double interes) {
        double interesGanado = monto * (interes / 100.0);
        return String.format("Con una inversión de $%.2f y un interés del %.2f%%, se ganan $%.2f por interés.", monto, interes, interesGanado);
    }
}