package Ejercicios_ciclos.seccion4;

public class Ejercicio4_2 {
    public static void main(String[] args) {
        System.out.println("Números pares que no son múltiplos de 5 (1 al 50):");

        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0 || i % 5 == 0) {
                continue; // Salta impares y múltiplos de 5
            }
            System.out.println(i);
        }
    }
}