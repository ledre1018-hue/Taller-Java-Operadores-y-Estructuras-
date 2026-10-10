package com.taller.practico;

public class DiaSemanaModerno {
    public static void main(String[] args) {
        int numeroDia = 6;

        String tipoJornada = switch (numeroDia) {
            case 1, 2, 3, 4, 5 -> "Jornada laboral";
            case 6             -> "Jornada reducida";
            case 7             -> "Descanso";
            default            -> "Día inválido";
        };

        System.out.println("Día " + numeroDia + " (moderno): " + tipoJornada);
    }
}
