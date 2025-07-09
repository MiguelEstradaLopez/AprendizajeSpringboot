package com.projecto1.api_tarea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayMergeController {

    /**
     * Endpoint para mezclar dos arreglos de números enteros ordenados.
     * Ejemplo de uso: GET /arreglos/mezclar?arr1=1,3,6,9,17&arr2=2,4,10,17
     * @param arr1 Primera cadena de números enteros separados por comas, ordenados ascendentemente.
     * @param arr2 Segunda cadena de números enteros separados por comas, ordenados ascendentemente.
     * @return Una cadena con la lista ordenada de la mezcla, o un mensaje de error.
     */
    @GetMapping("/arreglos/mezclar")
    public String mezclarArreglosOrdenados(
            @RequestParam String arr1,
            @RequestParam String arr2) {

        List<Integer> list1;
        List<Integer> list2;

        try {
            // Convertir la primera cadena a una lista de enteros
            list1 = Arrays.stream(arr1.split(","))
                          .map(String::trim)
                          .map(Integer::parseInt)
                          .collect(Collectors.toList());

            // Convertir la segunda cadena a una lista de enteros
            list2 = Arrays.stream(arr2.split(","))
                          .map(String::trim)
                          .map(Integer::parseInt)
                          .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return "Error: Formato de números inválido en una de las listas. Asegúrese de que todos los valores son enteros válidos y están separados por comas.";
        }

        // Crear una nueva lista para la mezcla y añadir todos los elementos
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        // Ordenar la lista mezclada.
        // Aunque el problema especifica que las entradas están ordenadas,
        // Collections.sort garantiza que la mezcla final esté ordenada.
        Collections.sort(mergedList);

        // Formatear la salida
        String resultadoFormateado = mergedList.stream()
                                               .map(String::valueOf)
                                               .collect(Collectors.joining(", "));

        return "La lista mezclada y ordenada es: " + resultadoFormateado;
    }
}