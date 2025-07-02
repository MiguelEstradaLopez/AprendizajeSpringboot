package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {

    /**
     * Endpoint para invertir un número de dos cifras.
     * Ejemplo de uso: GET /numeros/invertir-dos-cifras?numero=15
     * @param numero El número de dos cifras a invertir.
     * @return Mensaje con el número invertido o un error si no es de dos cifras.
     */
    @GetMapping("/numeros/invertir-dos-cifras")
    public String invertirNumeroDosCifras(@RequestParam int numero) {
        if (numero < 10 || numero > 99) { // Solo para números positivos de 2 cifras
            return "Error: El número debe ser de dos cifras (entre 10 y 99).";
        }

        int unidades = numero % 10;
        int decenas = numero / 10;

        int numeroInvertido = (unidades * 10) + decenas;

        return String.format("El número original es %d, el número invertido es %d.", numero, numeroInvertido);
    }
}