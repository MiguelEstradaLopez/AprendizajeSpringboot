package com.projecto1.api_tarea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixRowSumController {

    private static final int MAX_FILAS = 100;
    private static final int MAX_COLUMNAS = 50;

    /**
     * Endpoint para calcular la suma de las filas de una matriz.
     * Ejemplo de uso: GET /matriz/suma-filas?filas=3&columnas=5&elementos=3.5,6.5,30,8.2,0,4,0,-1,3.6,1.4,10,-1.5,3.4,6.6,2
     * @param filas Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     * @param elementos Cadena de números (dobles) separados por comas que representan los elementos de la matriz, fila por fila.
     * @return Un string con el arreglo de las sumas de cada fila, o un mensaje de error.
     */
    @GetMapping("/matriz/suma-filas")
    public String sumarFilasMatriz(
            @RequestParam int filas,
            @RequestParam int columnas,
            @RequestParam String elementos) {

        // 1. Validar dimensiones
        if (filas <= 0 || columnas <= 0) {
            return "Error: El número de filas y columnas debe ser positivo.";
        }
        if (filas > MAX_FILAS || columnas > MAX_COLUMNAS) {
            return String.format("Error: La dimensión máxima de la matriz es %dx%d.", MAX_FILAS, MAX_COLUMNAS);
        }

        // 2. Parsear elementos
        List<Double> listaElementos;
        try {
            listaElementos = Arrays.stream(elementos.split(","))
                                   .map(String::trim)
                                   .filter(s -> !s.isEmpty())
                                   .map(Double::parseDouble)
                                   .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return "Error: Formato de elementos inválido. Asegúrese de que todos los valores son números válidos y están separados por comas.";
        }

        // 3. Validar cantidad de elementos
        int totalElementosEsperados = filas * columnas;
        if (listaElementos.size() != totalElementosEsperados) {
            return String.format("Error: Se esperaban %d elementos para una matriz de %dx%d, pero se recibieron %d.",
                    totalElementosEsperados, filas, columnas, listaElementos.size());
        }

        // 4. Llenar la matriz
        double[][] matriz = new double[filas][columnas];
        int k = 0; // Índice para recorrer listaElementos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = listaElementos.get(k++);
            }
        }

        // 5. Calcular la suma de cada fila
        List<Double> sumasFilas = new ArrayList<>(filas);
        for (int i = 0; i < filas; i++) {
            double sumaFilaActual = 0.0;
            for (int j = 0; j < columnas; j++) {
                sumaFilaActual += matriz[i][j];
            }
            sumasFilas.add(sumaFilaActual);
        }

        // 6. Formatear el resultado
        String resultadoFormateado = sumasFilas.stream()
                                               .map(s -> String.format("%.2f", s)) // Formatear a dos decimales
                                               .collect(Collectors.joining(", "));

        return "La matriz ingresada es:\n" + formatMatrix(matriz) +
               "\nLa suma de las filas es: [" + resultadoFormateado + "]";
    }

    // Helper method to format the matrix for output
    private String formatMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "Matriz vacía o nula.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%7.2f", matrix[i][j])); // Formato para alinear números decimales
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}