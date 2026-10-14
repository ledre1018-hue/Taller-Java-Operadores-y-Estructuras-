package Ejercicios_ciclos.seccion1;

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int acumulador = 0;
        int contador = 0;

        System.out.println("Ingrese números enteros (ingrese -99 para salir):");
        numero = sc.nextInt();

        while (numero != -99) {
            acumulador += numero;
            contador++;
            numero = sc.nextInt();
        }

        System.out.println("Total acumulado de los números ingresados: " + acumulador);
        System.out.println("Cantidad exacta de entradas procesadas: " + contador);
    }
}