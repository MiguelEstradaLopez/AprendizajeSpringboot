package com.projecto1.api_tarea.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixUtils {

    /**
     * Convierte una cadena de elementos separados por comas a una lista de dobles.
     * @param elementsStr Cadena de elementos.
     * @param name Nombre de la matriz para mensajes de error.
     * @return Lista de dobles.
     * @throws IllegalArgumentException Si el formato es incorrecto.
     */
    public static List<Double> parseElements(String elementsStr, String name) {
        try {
            return Arrays.stream(elementsStr.split(","))
                         .map(String::trim)
                         .filter(s -> !s.isEmpty())
                         .map(Double::parseDouble)
                         .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para los elementos de la matriz " + name + ". Asegúrese de que son números válidos separados por comas.");
        }
    }

    /**
     * Llena una matriz 2D con elementos de una lista 1D.
     * @param filas Número de filas.
     * @param columnas Número de columnas.
     * @param listaElementos Lista de elementos en orden de fila por fila.
     * @param name Nombre de la matriz para mensajes de error.
     * @return La matriz 2D llena.
     * @throws IllegalArgumentException Si la cantidad de elementos no coincide con las dimensiones.
     */
    public static double[][] fillMatrix(int filas, int columnas, List<Double> listaElementos, String name) {
        int totalElementosEsperados = filas * columnas;
        if (listaElementos.size() != totalElementosEsperados) {
            throw new IllegalArgumentException(String.format("Error: Se esperaban %d elementos para la matriz %s de %dx%d, pero se recibieron %d.",
                    totalElementosEsperados, name, filas, columnas, listaElementos.size()));
        }

        double[][] matrix = new double[filas][columnas];
        int k = 0; // Índice para recorrer listaElementos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrix[i][j] = listaElementos.get(k++);
            }
        }
        return matrix;
    }

    /**
     * Formatea una matriz 2D en una cadena para su visualización.
     * @param matrix La matriz a formatear.
     * @param title Título opcional para la matriz.
     * @return Cadena formateada de la matriz.
     */
    public static String formatMatrix(double[][] matrix, String title) {
        if (matrix == null || matrix.length == 0 || (matrix.length > 0 && matrix[0].length == 0)) {
            return (title != null ? title + ": " : "") + "Matriz vacía o nula.\n";
        }

        StringBuilder sb = new StringBuilder();
        if (title != null && !title.isEmpty()) {
            sb.append(title).append(":\n");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%9.3f", matrix[i][j])); // Ajustado para 3 decimales y espacio
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}