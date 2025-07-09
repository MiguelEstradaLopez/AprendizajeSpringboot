package com.projecto1.api_tarea.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamenController {

    /**
     * Endpoint para calificar un examen de selección múltiple.
     * Ejemplo de uso: GET /examen/calificar?numPreguntas=5&respEstudiante=a,b,c,d,e&respCorrectas=A,B,C,A,E
     * @param numPreguntas El número total de preguntas del examen.
     * @param respEstudiante Una cadena con las respuestas del estudiante, separadas por comas (ej. "a,b,c").
     * @param respCorrectas Una cadena con las respuestas correctas, separadas por comas (ej. "A,B,C").
     * @return Un mensaje con la nota obtenida o un error de validación.
     */
    @GetMapping("/examen/calificar")
    public String calificarExamen(
            @RequestParam int numPreguntas,
            @RequestParam String respEstudiante,
            @RequestParam String respCorrectas) {

        // Convertir las cadenas de respuestas a listas de caracteres.
        // ¡NUEVO!: Convertir cada respuesta a MAYÚSCULAS inmediatamente después de trim.
        List<String> estudianteRespuestasList = Arrays.stream(respEstudiante.split(","))
                                                    .map(String::trim)
                                                    .map(String::toUpperCase) // <--- CAMBIO CLAVE AQUÍ
                                                    .collect(Collectors.toList());
        List<String> correctasRespuestasList = Arrays.stream(respCorrectas.split(","))
                                                   .map(String::trim)
                                                   .map(String::toUpperCase) // <--- CAMBIO CLAVE AQUÍ
                                                   .collect(Collectors.toList());

        // REQUIERE 1: El número de preguntas del examen debe ser mayor que cero.
        if (numPreguntas <= 0) {
            return "Error: El número de preguntas debe ser mayor que cero.";
        }

        // Validar que la cantidad de respuestas coincida con el número de preguntas
        if (estudianteRespuestasList.size() != numPreguntas || correctasRespuestasList.size() != numPreguntas) {
            return String.format("Error: La cantidad de respuestas proporcionadas (%d para estudiante, %d para correctas) no coincide con el número de preguntas (%d).",
                                 estudianteRespuestasList.size(), correctasRespuestasList.size(), numPreguntas);
        }

        // REQUIERE 2 y 3: Cada respuesta debe ser una letra mayúscula entre A y E.
        // Ahora que ya convertimos a MAYÚSCULAS, solo necesitamos verificar que sea una de las opciones válidas.
        String opcionesValidas = "ABCDE";
        for (String resp : estudianteRespuestasList) {
            if (resp.length() != 1 || !opcionesValidas.contains(resp)) {
                return "Error: Todas las respuestas del estudiante deben ser una letra entre A y E (ignorando mayúsculas/minúsculas).";
            }
        }
        for (String resp : correctasRespuestasList) {
            if (resp.length() != 1 || !opcionesValidas.contains(resp)) {
                return "Error: Todas las respuestas correctas deben ser una letra entre A y E (ignorando mayúsculas/minúsculas).";
            }
        }

        // Calcular la nota
        int notaObtenida = 0;
        for (int i = 0; i < numPreguntas; i++) {
            if (estudianteRespuestasList.get(i).equals(correctasRespuestasList.get(i))) {
                notaObtenida++;
            }
        }

        // GARANTIZA: La nota corresponde al total de aciertos.
        return String.format("La nota obtenida por el estudiante (número de aciertos) es: %d", notaObtenida);
    }
}