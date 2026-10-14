package Ejercicios_ciclos.seccion3;

import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo N: ");
        int n = sc.nextInt();

        // Parte A: Factorial (usamos long para evitar desbordamiento)
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + n + " es: " + factorial);

        // Parte B: Patrón triangular con for anidados
        System.out.println("\n--- Patrón Triangular ---");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}