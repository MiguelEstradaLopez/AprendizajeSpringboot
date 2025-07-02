package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacionesController {

    /**
     * Endpoint para realizar operaciones básicas (suma, producto, diferencia, cociente) con dos números.
     * Ejemplo de uso: GET /operaciones/basicas?num1=10&num2=3
     * @param num1 El primer número.
     * @param num2 El segundo número.
     * @return Una cadena formateada con los resultados de las operaciones.
     */
    @GetMapping("/operaciones/basicas")
    public String realizarOperacionesBasicas(@RequestParam double num1, @RequestParam double num2) {
        StringBuilder sb = new StringBuilder();

        double suma = num1 + num2;
        double producto = num1 * num2;
        double diferencia = num1 - num2;

        sb.append(String.format("Números ingresados: %.2f y %.2f%n", num1, num2));
        sb.append(String.format("Suma: %.2f%n", suma));
        sb.append(String.format("Producto: %.2f%n", producto));
        sb.append(String.format("Diferencia: %.2f%n", diferencia));

        if (num2 != 0) {
            double cociente = num1 / num2;
            sb.append(String.format("Cociente: %.2f%n", cociente));
        } else {
            sb.append("Cociente: Indefinido (división por cero)%n");
        }
        
        // Usamos <br> para los saltos de línea en HTML, ya que esto será mostrado en un div
        return sb.toString().replace("%n", "<br>");
    }
}