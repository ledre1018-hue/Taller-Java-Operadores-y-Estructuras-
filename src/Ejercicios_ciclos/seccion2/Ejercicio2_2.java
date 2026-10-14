package Ejercicios_ciclos.seccion2;

import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double saldo = 500000;

        do {
            System.out.println("\n--- Plataforma Bancaria ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Retiro");
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $" + saldo);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    saldo += sc.nextDouble();
                    System.out.println("Depósito realizado con éxito.");
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    saldo -= sc.nextDouble();
                    System.out.println("Retiro realizado con éxito.");
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 4);
    }
}