package Ejercicios_ciclos.seccion1;

import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean procesando = true;
        double acumulador = 0;
        String causa = "";

        System.out.println("--- Sistema de gestión de transacciones ---");

        while (procesando) {
            System.out.print("Ingrese el monto de la transacción: ");
            double monto = sc.nextDouble();

            if (monto < 0) {
                procesando = false;
                causa = "Se ingresó un monto negativo (no válido).";
            } else {
                acumulador += monto;
                if (acumulador > 1000000) {
                    procesando = false;
                    causa = "El acumulador total superó el límite máximo de $1'000.000.";
                }
            }
        }

        System.out.println("\n--- Informe Final ---");
        System.out.println("Saldo final acumulado: $" + acumulador);
        System.out.println("Causa de finalización: " + causa);
    }
}