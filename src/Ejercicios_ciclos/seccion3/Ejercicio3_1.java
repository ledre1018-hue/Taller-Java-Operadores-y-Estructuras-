package Ejercicios_ciclos.seccion3;

import java.util.Scanner;

public class Ejercicio3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número entero N: ");
        int n = sc.nextInt();

        System.out.println("\n--- Tabla de Multiplicar del " + n + " ---");
        for (int i = 1; i <= 12; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        System.out.println("\n--- Conteo Regresivo desde " + n + " ---");
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }
}