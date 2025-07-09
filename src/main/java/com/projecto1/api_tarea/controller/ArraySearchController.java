package com.projecto1.api_tarea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArraySearchController {

    /**
     * Endpoint para buscar un número en un arreglo y devolver sus índices.
     * Los índices se devuelven en base 1, según el ejemplo del problema.
     * Ejemplo de uso: GET /arreglos/buscar-indices?arreglo=1,2,3,100,23,2,2,1&numeroX=2
     * @param arreglo Una cadena de números enteros separados por comas.
     * @param numeroX El número entero a buscar.
     * @return Una cadena con los índices donde se encontró el número, o un mensaje.
     */
    @GetMapping("/arreglos/buscar-indices")
    public String buscarIndicesEnArreglo(
            @RequestParam String arreglo,
            @RequestParam int numeroX) {

        List<Integer> numeros;
        try {
            numeros = Arrays.stream(arreglo.split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty()) // Filtra cadenas vacías resultantes de comas extra
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return "Error: Formato de arreglo inválido. Asegúrese de que todos los valores son números enteros válidos y están separados por comas.";
        }

        if (numeros.isEmpty()) {
            return "El arreglo está vacío. No se encontraron índices para " + numeroX + ".";
        }

        List<Integer> indicesEncontrados = new ArrayList<>();
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numeroX) {
                // Sumar 1 al índice para que sea base 1, como en el ejemplo del problema
                indicesEncontrados.add(i + 1);
            }
        }

        if (indicesEncontrados.isEmpty()) {
            return "El número " + numeroX + " no fue encontrado en el arreglo.";
        } else {
            // Formatear la salida con espacios, como en el ejemplo
            String resultadoFormateado = indicesEncontrados.stream()
                                                            .map(String::valueOf)
                                                            .collect(Collectors.joining(" "));
            return "El programa debe escribir: " + resultadoFormateado;
        }
    }
}