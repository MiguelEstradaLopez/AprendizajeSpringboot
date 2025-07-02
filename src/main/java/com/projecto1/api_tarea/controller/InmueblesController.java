package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InmueblesController {

    private static final double PORCENTAJE_CUOTA_INICIAL = 0.20; // 20%
    private static final int NUM_CUOTAS_INICIAL = 24;

    /**
     * Endpoint para calcular la cuota inicial, el valor restante a prestar y la cuota mensual de la cuota inicial de una casa.
     * Ejemplo de uso: GET /inmuebles/calcular-casa?valor=250000000
     * @param valor El valor total de la casa.
     * @return Una cadena formateada con los resultados del cálculo.
     */
    @GetMapping("/inmuebles/calcular-casa")
    public String calcularValoresCasa(@RequestParam double valor) {
        StringBuilder sb = new StringBuilder();

        double cuotaInicial = valor * PORCENTAJE_CUOTA_INICIAL;
        double valorRestantePrestamo = valor - cuotaInicial;
        double cuotaMensualInicial = cuotaInicial / NUM_CUOTAS_INICIAL;

        sb.append(String.format("Valor total de la casa: $%.2f<br>", valor));
        sb.append(String.format("Valor de la cuota inicial (20%%): $%.2f<br>", cuotaInicial));
        sb.append(String.format("Valor restante a prestar al banco: $%.2f<br>", valorRestantePrestamo));
        sb.append(String.format("Valor mensual a pagar de cuota inicial (en %d cuotas): $%.2f", NUM_CUOTAS_INICIAL, cuotaMensualInicial));

        return sb.toString();
    }
}