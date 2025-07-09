package com.projecto1.api_tarea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalizacionController {

    /**
     * Endpoint para normalizar una colección de números reales.
     * Los valores resultantes estarán en el intervalo [0, 1].
     * Ejemplo de uso: GET /normalizacion/normalizar?numeros=10.5,20.0,5.2,15.0
     * @param numeros Una cadena de números reales separados por comas (ej. "1.0,2.5,0.5").
     * @return Una cadena con los números normalizados o un mensaje de error.
     */
    @GetMapping("/normalizacion/normalizar")
    public String normalizarNumeros(
            @RequestParam String numeros) {

        // 1. Convertir la cadena de entrada a una lista de Double
        List<Double> coleccionNumeros;
        try {
            coleccionNumeros = Arrays.stream(numeros.split(","))
                                    .map(String::trim)
                                    .map(Double::parseDouble)
                                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return "Error: Formato de números inválido. Asegúrese de que todos los valores son números reales válidos y están separados por comas.";
        }

        // 2. Manejar el caso de una colección vacía
        if (coleccionNumeros.isEmpty()) {
            return "Error: La colección de números no puede estar vacía.";
        }

        // 3. Encontrar el número mayor de la colección
        // OptionalDouble es usado porque max() puede no encontrar un valor si la lista está vacía
        OptionalDouble maxOpt = coleccionNumeros.stream()
                                               .mapToDouble(Double::doubleValue)
                                               .max();

        double valorMaximo;
        if (maxOpt.isPresent()) {
            valorMaximo = maxOpt.getAsDouble();
        } else {
            // Esto no debería ocurrir si coleccionNumeros.isEmpty() ya fue verificado,
            // pero es una buena práctica de manejo de Optional.
            return "Error: No se pudo determinar el valor máximo en la colección.";
        }

        // 4. Manejar el caso donde el valor máximo es cero
        if (valorMaximo == 0.0) {
            // Si el valor máximo es 0, y todos los números son 0, todos los normalizados también serán 0.
            // Si hay números negativos y el máximo es 0 (lo que implicaría que solo hay 0s y negativos),
            // la normalización con 0 como divisor causaría un error.
            // Para este problema, asumiremos que si el máximo es 0, todos los elementos son 0
            // o se desea que la salida sea 0 para todos.
            boolean allZeros = coleccionNumeros.stream().allMatch(n -> n == 0.0);
            if (allZeros) {
                return "Números normalizados: " + coleccionNumeros.stream()
                                                                  .map(n -> "0.0")
                                                                  .collect(Collectors.joining(", "));
            } else {
                 // Si el máximo es 0 y no todos son 0, significa que hay números negativos y el 0 es el máximo.
                 // Esto puede llevar a resultados inesperados o divisiones por 0 si el input es malicioso (ej. "0, -5").
                 // Podríamos optar por un mensaje de error o una normalización especial.
                 // Para simplicidad en este ejercicio, devolvemos un error si el máximo es 0 y hay no ceros.
                 return "Error: El valor máximo es cero, y hay números distintos de cero. Normalización no definida para este caso con valores negativos.";
            }
        }

        // 5. Normalizar cada número dividiéndolo por el valor máximo
        List<Double> numerosNormalizados = new ArrayList<>();
        for (Double num : coleccionNumeros) {
            numerosNormalizados.add(num / valorMaximo);
        }

        // 6. Formatear la salida para que sea legible
        String resultadoFormateado = numerosNormalizados.stream()
                                                        .map(d -> String.format("%.4f", d)) // Formato a 4 decimales
                                                        .collect(Collectors.joining(", "));

        return "Números normalizados: " + resultadoFormateado;
    }
}