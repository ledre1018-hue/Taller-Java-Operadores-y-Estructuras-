package com.taller.practico;

public class DiaSemanaTradicional {
    public static void main(String[] args) {
        int numeroDia = 6;
        String tipoJornada;

        switch (numeroDia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                tipoJornada = "Jornada laboral";
                break;
            case 6:
                tipoJornada = "Jornada reducida";
                break;
            case 7:
                tipoJornada = "Descanso";
                break;
            default:
                tipoJornada = "Día inválido";
        }

        System.out.println("Día " + numeroDia + " (tradicional): " + tipoJornada);
    }
}
