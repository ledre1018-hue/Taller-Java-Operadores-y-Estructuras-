package com.taller.practico;

public class SistemaAprobacion {
    public static void main(String[] args) {
        double calificacionFinal = 75.0;
        int porcentajeAsistencia = 85;
        boolean entregoProyectoFinal = false;

        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            System.out.println("Estado: APROBADO");
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            System.out.println("Estado: Pendiente de Examen Extraordinario");
        } else {
            System.out.println("Estado: REPROBADO");
        }
    }
}
