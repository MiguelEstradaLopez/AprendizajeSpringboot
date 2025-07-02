package com.projecto1.api_tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperaturaController {

    /**
     * Endpoint para convertir grados Fahrenheit a Celsius.
     * Ejemplo de uso: GET /temperatura/fahrenheit-to-celsius?fahrenheit=68
     * @param fahrenheit Grados Fahrenheit a convertir.
     * @return Mensaje con el resultado en Celsius.
     */
    @GetMapping("/temperatura/fahrenheit-to-celsius")
    public String convertirFahrenheitACelsius(@RequestParam double fahrenheit) {
        double celsius = (5.0 / 9.0) * (fahrenheit - 32);
        return String.format("%.2f °F es igual a %.2f °C", fahrenheit, celsius);
    }
}