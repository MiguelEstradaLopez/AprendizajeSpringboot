package com.projecto1.api_tarea.controller;

import com.projecto1.api_tarea.model.AspectoCalificacion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestauranteControllerCalidad {

    /**
     * Endpoint para procesar calificaciones de aspectos de restaurante.
     * Ejemplo de uso: GET /restaurante/calificaciones?atencion=8,9,7,10,8&comida=9,8,9,7,10&precio=7,7,8,6,7&ambiente=8,9,8,9,9
     * @param atencion Calificaciones de atención (5 clientes).
     * @param comida Calificaciones de comida (5 clientes).
     * @param precio Calificaciones de precio (5 clientes).
     * @param ambiente Calificaciones de ambiente (5 clientes).
     * @return Promedios de calificaciones ordenados de mejor a peor aspecto, o un mensaje de error.
     */
    @GetMapping("/restaurante/calificaciones")
    public String procesarCalificaciones(
            @RequestParam String atencion,
            @RequestParam String comida,
            @RequestParam String precio,
            @RequestParam String ambiente) {

        List<AspectoCalificacion> aspectosPromedios = new ArrayList<>();

        try {
            aspectosPromedios.add(new AspectoCalificacion("Atención", calcularPromedio(atencion, "Atención")));
            aspectosPromedios.add(new AspectoCalificacion("Calidad de la Comida", calcularPromedio(comida, "Calidad de la Comida")));
            aspectosPromedios.add(new AspectoCalificacion("Justicia del Precio", calcularPromedio(precio, "Justicia del Precio")));
            aspectosPromedios.add(new AspectoCalificacion("Ambiente", calcularPromedio(ambiente, "Ambiente")));
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }

        // Ordenar los aspectos por promedio de mayor a menor
        Collections.sort(aspectosPromedios);

        // Formatear la salida
        return "Promedios de Calificación (De Mejor a Peor):\n" +
               aspectosPromedios.stream()
                                .map(AspectoCalificacion::toString)
                                .collect(Collectors.joining("\n"));
    }

    /**
     * Método auxiliar para calcular el promedio de una cadena de calificaciones.
     * Realiza validaciones.
     * @param calificacionesStr Cadena de calificaciones separadas por comas.
     * @param nombreAspecto Nombre del aspecto para mensajes de error.
     * @return El promedio de las calificaciones.
     * @throws IllegalArgumentException Si las calificaciones son inválidas.
     */
    private double calcularPromedio(String calificacionesStr, String nombreAspecto) {
        List<Integer> calificaciones;
        try {
            calificaciones = Arrays.stream(calificacionesStr.split(","))
                                   .map(String::trim)
                                   .filter(s -> !s.isEmpty())
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato inválido para las calificaciones de " + nombreAspecto + ". Asegúrese de que son números enteros separados por comas.");
        }

        if (calificaciones.size() != 5) {
            throw new IllegalArgumentException("Deben ingresarse exactamente 5 calificaciones para " + nombreAspecto + ".");
        }

        for (int cal : calificaciones) {
            if (cal < 1 || cal > 10) {
                throw new IllegalArgumentException("Las calificaciones de " + nombreAspecto + " deben estar entre 1 y 10.");
            }
        }

        return calificaciones.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}