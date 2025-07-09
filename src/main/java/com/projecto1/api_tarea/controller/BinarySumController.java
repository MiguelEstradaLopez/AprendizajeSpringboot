package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinarySumController {

    /**
     * Endpoint para sumar dos números binarios.
     * Ejemplo de uso: GET /binario/sumar?binario1=101&binario2=1101
     * @param binario1 Primera cadena binaria.
     * @param binario2 Segunda cadena binaria.
     * @return La suma de los dos binarios en formato binario, o un mensaje de error.
     */
    @GetMapping("/binario/sumar")
    public String sumarBinarios(
            @RequestParam String binario1,
            @RequestParam String binario2) {

        // Validar que las cadenas solo contengan '0' y '1'
        if (!binario1.matches("^[01]+$") || !binario2.matches("^[01]+$")) {
            return "Error: Ambas entradas deben ser cadenas binarias válidas (solo '0' y '1').";
        }

        try {
            // Convertir las cadenas binarias a números decimales (long para mayor rango)
            long decimal1 = Long.parseLong(binario1, 2); // Base 2 para binario
            long decimal2 = Long.parseLong(binario2, 2); // Base 2 para binario

            // Sumar los números decimales
            long sumaDecimal = decimal1 + decimal2;

            // Convertir el resultado decimal de nuevo a cadena binaria
            String resultadoBinario = Long.toBinaryString(sumaDecimal);

            return "La suma binaria es: " + resultadoBinario;
        } catch (NumberFormatException e) {
            // Esto podría ocurrir si los números binarios son demasiado grandes para 'long'
            return "Error: Uno o ambos números binarios son demasiado grandes para procesar.";
        }
    }
}