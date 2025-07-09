package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixOperationsController {

    // --- Helper Method to format the matrix for output ---
    private String formatMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "Matriz vacía o nula.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%4d", matrix[i][j])); // Formato para alinear números
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Algoritmo 1: Pone cero en ambas diagonales de la matriz.
     * Ejemplo: GET /matriz/diagonales-cero?n=5
     * @param n Dimensión de la matriz (NxN).
     * @return La matriz con las diagonales en cero.
     */
    @GetMapping("/matriz/diagonales-cero")
    public String ponerCeroDiagonales(@RequestParam int n) {
        if (n <= 0) {
            return "Error: N debe ser un entero positivo.";
        }
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Inicializar la matriz con algún valor por defecto (ej. 1, para ver el cambio)
                // O dejar en 0 si queremos solo mostrar los cambios.
                // Para este ejemplo, la inicializamos con 0 y solo modificamos las diagonales a 0 (si no lo están ya).
                // Pero si la inicializamos con otros valores, el efecto es más visible.
                mat[i][j] = 1; // Podemos inicializarla con 1s para ver los 0s en las diagonales.
            }
        }

        for (int i = 0; i < n; i++) {
            mat[i][i] = 0; // Diagonal principal
            mat[i][n - 1 - i] = 0; // Diagonal secundaria
        }
        return "Matriz con diagonales en cero:\n" + formatMatrix(mat);
    }

    /**
     * Algoritmo 2: Pone cero en la primera y la última fila, y en la primera y la última columna de la matriz.
     * Ejemplo: GET /matriz/bordes-cero?n=5
     * @param n Dimensión de la matriz (NxN).
     * @return La matriz con los bordes en cero.
     */
    @GetMapping("/matriz/bordes-cero")
    public String ponerCeroBordes(@RequestParam int n) {
        if (n <= 0) {
            return "Error: N debe ser un entero positivo.";
        }
        int[][] mat = new int[n][n];

        // Inicializar la matriz con algún valor para visualizar los ceros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 1; // Rellenar con 1s
            }
        }

        // Primera fila (índice 0)
        for (int j = 0; j < n; j++) {
            mat[0][j] = 0;
        }

        // Última fila (índice n-1)
        if (n > 1) { // Asegurarse de que la matriz tenga al menos 2 filas
            for (int j = 0; j < n; j++) {
                mat[n - 1][j] = 0;
            }
        }

        // Primera columna (índice 0) - excluyendo esquinas ya puestas a cero por filas
        for (int i = 0; i < n; i++) {
            mat[i][0] = 0;
        }

        // Última columna (índice n-1) - excluyendo esquinas ya puestas a cero por filas
        if (n > 1) { // Asegurarse de que la matriz tenga al menos 2 columnas
            for (int i = 0; i < n; i++) {
                mat[i][n - 1] = 0;
            }
        }
        return "Matriz con bordes en cero:\n" + formatMatrix(mat);
    }

    /**
     * Algoritmo 3: Llena la matriz de tal forma que mat[i][j] sea igual a i+j.
     * Ejemplo: GET /matriz/llenar-suma-indices?n=4
     * @param n Dimensión de la matriz (NxN).
     * @return La matriz con mat[i][j] = i+j.
     */
    @GetMapping("/matriz/llenar-suma-indices")
    public String llenarSumaIndices(@RequestParam int n) {
        if (n <= 0) {
            return "Error: N debe ser un entero positivo.";
        }
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = i + j;
            }
        }
        return "Matriz con mat[i][j] = i+j:\n" + formatMatrix(mat);
    }

    /**
     * Algoritmo 4: Llena la diagonal principal de la matriz con los números 1,2,3,...N.
     * Ejemplo: GET /matriz/diagonal-principal-secuencia?n=5
     * @param n Dimensión de la matriz (NxN).
     * @return La matriz con la diagonal principal rellena.
     */
    @GetMapping("/matriz/diagonal-principal-secuencia")
    public String llenarDiagonalPrincipalSecuencia(@RequestParam int n) {
        if (n <= 0) {
            return "Error: N debe ser un entero positivo.";
        }
        int[][] mat = new int[n][n];

        // Opcional: Rellenar el resto de la matriz con ceros o un valor por defecto
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0; // O cualquier otro valor para el resto de la matriz
            }
        }

        for (int i = 0; i < n; i++) {
            mat[i][i] = i + 1; // Rellenar la diagonal principal con 1, 2, ..., N
        }
        return "Matriz con diagonal principal (1...N):\n" + formatMatrix(mat);
    }

    /**
     * Algoritmo 5: Llena las filas pares con 1,2,3,...N y las impares con N,N-1,N-2,...1.
     * Ejemplo: GET /matriz/llenar-filas-alternado?n=4
     * @param n Dimensión de la matriz (NxN).
     * @return La matriz con filas pares/impares rellenas alternadamente.
     */
    @GetMapping("/matriz/llenar-filas-alternado")
    public String llenarFilasAlternado(@RequestParam int n) {
        if (n <= 0) {
            return "Error: N debe ser un entero positivo.";
        }
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // Fila par (0, 2, 4...)
                for (int j = 0; j < n; j++) {
                    mat[i][j] = j + 1; // 1, 2, 3, ..., N
                }
            } else { // Fila impar (1, 3, 5...)
                for (int j = 0; j < n; j++) {
                    mat[i][j] = n - j; // N, N-1, N-2, ..., 1
                }
            }
        }
        return "Matriz con filas pares (1..N) e impares (N..1):\n" + formatMatrix(mat);
    }
}