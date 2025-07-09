package com.projecto1.api_tarea.model;

public class AspectoCalificacion implements Comparable<AspectoCalificacion> {
    private String nombre;
    private double promedio;

    public AspectoCalificacion(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public int compareTo(AspectoCalificacion otro) {
        // Ordenar de mayor a menor promedio
        return Double.compare(otro.promedio, this.promedio);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", nombre, promedio);
    }
}