package Ejercicios_ciclos.seccion5;

import java.util.Scanner;

public class EjercicioIntegrador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int totalUnidadesAlmacen = 0;
        final int CAPACIDAD_MAXIMA = 500;

        do {
            System.out.println("\n--- Control de Inventario ---");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de productos que componen el lote: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n--- Producto " + i + " ---");

                        double precio;
                        int stock;

                        // Validación estricta de precio (debe ser > 0)
                        do {
                            System.out.print("Ingrese el precio (debe ser > 0): ");
                            precio = sc.nextDouble();
                            if (precio <= 0) System.out.println("Error: El valor debe ser mayor a cero.");
                        } while (precio <= 0);

                        // Validación estricta de stock (debe ser > 0)
                        do {
                            System.out.print("Ingrese la cantidad en stock (debe ser > 0): ");
                            stock = sc.nextInt();
                            if (stock <= 0) System.out.println("Error: El valor debe ser mayor a cero.");
                        } while (stock <= 0);

                        // Filtrado de productos descontinuados
                        System.out.print("¿El producto está descontinuado? (1=Si, 0=No): ");
                        int descontinuado = sc.nextInt();
                        if (descontinuado == 1) {
                            System.out.println("Producto descontinuado. Ignorando procesamiento...");
                            continue;
                        }

                        // Parada por capacidad crítica
                        if (totalUnidadesAlmacen + stock > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA DE SOBRECUPO! Capacidad crítica del almacén superada.");
                            break;
                        }

                        totalUnidadesAlmacen += stock;
                        System.out.println("Producto registrado exitosamente.");
                    }
                    break;

                case 2:
                    System.out.println("Estado actual del almacén: " + totalUnidadesAlmacen + " / " + CAPACIDAD_MAXIMA + " unidades.");
                    break;

                case 3:
                    System.out.println("Saliendo del sistema de inventario...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}