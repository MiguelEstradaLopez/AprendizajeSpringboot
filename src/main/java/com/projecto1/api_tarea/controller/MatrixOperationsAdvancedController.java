package com.projecto1.api_tarea.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projecto1.api_tarea.utils.MatrixUtils;

@RestController
public class MatrixOperationsAdvancedController {

    // --- Suma de dos matrices ---
    /**
     * Calcula la suma de dos matrices A y B.
     * Ejemplo: GET /matriz/suma
     * ?filasA=2&columnasA=2&elementosA=1,2,3,4
     * &filasB=2&columnasB=2&elementosB=5,6,7,8
     * @return La matriz resultante de la suma o un mensaje de error.
     */
    @GetMapping("/matriz/suma")
    public String sumarMatrices(
            @RequestParam int filasA, @RequestParam int columnasA, @RequestParam String elementosA,
            @RequestParam int filasB, @RequestParam int columnasB, @RequestParam String elementosB) {

        try {
            // Validar dimensiones (deben ser iguales para la suma)
            if (filasA <= 0 || columnasA <= 0 || filasB <= 0 || columnasB <= 0) {
                return "Error: Las dimensiones de las matrices deben ser positivas.";
            }
            if (filasA != filasB || columnasA != columnasB) {
                return "Error: Las matrices deben tener las mismas dimensiones para poder sumarse.";
            }

            // Parsear y llenar matrices
            List<Double> listaA = MatrixUtils.parseElements(elementosA, "A");
            double[][] matA = MatrixUtils.fillMatrix(filasA, columnasA, listaA, "A");

            List<Double> listaB = MatrixUtils.parseElements(elementosB, "B");
            double[][] matB = MatrixUtils.fillMatrix(filasB, columnasB, listaB, "B");

            // Realizar la suma
            double[][] matC = new double[filasA][columnasA];
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matC[i][j] = matA[i][j] + matB[i][j];
                }
            }

            return MatrixUtils.formatMatrix(matA, "Matriz A") + "\n" +
                   MatrixUtils.formatMatrix(matB, "Matriz B") + "\n" +
                   MatrixUtils.formatMatrix(matC, "Matriz C (A + B)");

        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    // --- Traspuesta de una matriz ---
    /**
     * Calcula la traspuesta de una matriz A.
     * Ejemplo: GET /matriz/traspuesta
     * ?filasA=2&columnasA=3&elementosA=1,2,3,4,5,6
     * @return La matriz traspuesta o un mensaje de error.
     */
    @GetMapping("/matriz/traspuesta")
    public String obtenerTraspuesta(
            @RequestParam int filasA, @RequestParam int columnasA, @RequestParam String elementosA) {

        try {
            if (filasA <= 0 || columnasA <= 0) {
                return "Error: Las dimensiones de la matriz deben ser positivas.";
            }

            List<Double> listaA = MatrixUtils.parseElements(elementosA, "A");
            double[][] matA = MatrixUtils.fillMatrix(filasA, columnasA, listaA, "A");

            // Crear la matriz traspuesta con dimensiones invertidas
            double[][] matB = new double[columnasA][filasA];
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matB[j][i] = matA[i][j];
                }
            }

            return MatrixUtils.formatMatrix(matA, "Matriz Original A") + "\n" +
                   MatrixUtils.formatMatrix(matB, "Matriz Traspuesta (A^T)");

        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    // --- Traza de una matriz cuadrada ---
    /**
     * Calcula la traza de una matriz cuadrada A.
     * Ejemplo: GET /matriz/traza
     * ?n=3&elementosA=1,2,3,4,5,6,7,8,9
     * @return El valor de la traza o un mensaje de error.
     */
    @GetMapping("/matriz/traza")
    public String obtenerTraza(
            @RequestParam int n, @RequestParam String elementosA) { // 'n' representa filas y columnas

        try {
            if (n <= 0) {
                return "Error: La dimensión N de la matriz debe ser positiva.";
            }

            List<Double> listaA = MatrixUtils.parseElements(elementosA, "A");
            double[][] matA = MatrixUtils.fillMatrix(n, n, listaA, "A"); // Matriz NxN

            // Calcular la traza
            double traza = 0.0;
            for (int i = 0; i < n; i++) {
                traza += matA[i][i];
            }

            return MatrixUtils.formatMatrix(matA, "Matriz A") + "\n" +
                   String.format("La traza de la matriz A es: %.3f", traza);

        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    // --- Multiplicación de dos matrices ---
    /**
     * Multiplica dos matrices A y B (A * B).
     * Ejemplo: GET /matriz/multiplicacion
     * ?filasA=2&columnasA=2&elementosA=1,2,3,4
     * &filasB=2&columnasB=2&elementosB=5,6,7,8
     * @return La matriz resultante de la multiplicación o un mensaje de error.
     */
    @GetMapping("/matriz/multiplicacion")
    public String multiplicarMatrices(
            @RequestParam int filasA, @RequestParam int columnasA, @RequestParam String elementosA,
            @RequestParam int filasB, @RequestParam int columnasB, @RequestParam String elementosB) {

        try {
            // Validar dimensiones
            if (filasA <= 0 || columnasA <= 0 || filasB <= 0 || columnasB <= 0) {
                return "Error: Las dimensiones de las matrices deben ser positivas.";
            }
            if (columnasA != filasB) {
                return "Error: Para multiplicar A*B, el número de columnas de A debe ser igual al número de filas de B.";
            }

            // Parsear y llenar matrices
            List<Double> listaA = MatrixUtils.parseElements(elementosA, "A");
            double[][] matA = MatrixUtils.fillMatrix(filasA, columnasA, listaA, "A");

            List<Double> listaB = MatrixUtils.parseElements(elementosB, "B");
            double[][] matB = MatrixUtils.fillMatrix(filasB, columnasB, listaB, "B");

            // Realizar la multiplicación
            double[][] matC = new double[filasA][columnasB]; // Matriz resultante nxk (filasA x columnasB)

            for (int i = 0; i < filasA; i++) { // Iterar sobre filas de la matriz resultante C (y A)
                for (int j = 0; j < columnasB; j++) { // Iterar sobre columnas de la matriz resultante C (y B)
                    double sum = 0.0;
                    for (int k = 0; k < columnasA; k++) { // Iterar sobre columnas de A / filas de B
                        sum += matA[i][k] * matB[k][j];
                    }
                    matC[i][j] = sum;
                }
            }

            return MatrixUtils.formatMatrix(matA, "Matriz A") + "\n" +
                   MatrixUtils.formatMatrix(matB, "Matriz B") + "\n" +
                   MatrixUtils.formatMatrix(matC, "Matriz C (A * B)");

        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}