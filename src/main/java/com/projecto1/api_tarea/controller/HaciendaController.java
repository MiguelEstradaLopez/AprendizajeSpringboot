package com.projecto1.api_tarea.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaciendaController {

    private static final int NUM_DIAS = 7; // Una semana
    private static final double MIN_PRODUCCION = 10.0; // Litros mínimos por vaca
    private static final double MAX_PRODUCCION = 40.0; // Litros máximos por vaca

    /**
     * Endpoint para simular y analizar la producción de leche de N vacas durante una semana.
     * Ejemplo de uso: GET /hacienda/produccion?numVacas=10
     * @param numVacas El número de vacas en el hato (N).
     * @return Un informe de la producción total diaria y la vaca con mayor producción por día.
     */
    @GetMapping("/hacienda/produccion")
    public String analizarProduccionLeche(
            @RequestParam int numVacas) {

        if (numVacas <= 0) {
            return "Error: El número de vacas debe ser mayor que cero.";
        }

        // Matriz para guardar la producción: [día][vaca]
        // Días 0-6 (Lunes-Domingo), Vacas 0 a numVacas-1
        double[][] produccionDiaria = new double[NUM_DIAS][numVacas];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append("--- Informe de Producción de Leche del Hato ---\n");
        sb.append("Número de Vacas: ").append(numVacas).append("\n\n");

        // 1. Llenar la matriz con producción aleatoria y mostrarla (opcional, para depuración/visualización)
        sb.append("Producción Diaria (Litros):\n");
        sb.append("Vaca  ");
        for (int v = 0; v < numVacas; v++) {
            sb.append(String.format("V%d    ", v + 1)); // Vacas 1-N
        }
        sb.append("\n");

        for (int dia = 0; dia < NUM_DIAS; dia++) {
            sb.append(String.format("Día %d: ", dia + 1)); // Días 1-7
            for (int vaca = 0; vaca < numVacas; vaca++) {
                // Generar producción aleatoria entre MIN_PRODUCCION y MAX_PRODUCCION
                produccionDiaria[dia][vaca] = MIN_PRODUCCION + (MAX_PRODUCCION - MIN_PRODUCCION) * random.nextDouble();
                sb.append(String.format("%.1f ", produccionDiaria[dia][vaca]));
            }
            sb.append("\n");
        }
        sb.append("\n");


        // 2. Calcular la producción total del hato en cada uno de los siete días
        sb.append("Producción Total Diaria del Hato:\n");
        for (int dia = 0; dia < NUM_DIAS; dia++) {
            double totalDia = 0;
            for (int vaca = 0; vaca < numVacas; vaca++) {
                totalDia += produccionDiaria[dia][vaca];
            }
            sb.append(String.format("Día %d: %.2f litros\n", dia + 1, totalDia));
        }
        sb.append("\n");

        // 3. Calcular el número de la vaca que dio más leche en cada día
        sb.append("Vaca con Mayor Producción por Día:\n");
        for (int dia = 0; dia < NUM_DIAS; dia++) {
            double maxProduccionDia = -1.0;
            int vacaConMasLeche = -1; // Usamos índice base 0, luego sumamos 1 para mostrar al usuario

            for (int vaca = 0; vaca < numVacas; vaca++) {
                if (produccionDiaria[dia][vaca] > maxProduccionDia) {
                    maxProduccionDia = produccionDiaria[dia][vaca];
                    vacaConMasLeche = vaca + 1; // Guardar el número de la vaca (base 1)
                }
            }
            sb.append(String.format("Día %d: Vaca %d (%.2f litros)\n", dia + 1, vacaConMasLeche, maxProduccionDia));
        }

        return sb.toString();
    }
}