package com.educacion.ahorcado;

import java.util.Scanner;

public class Main {
    static final int MAX_INTENTOS_BASE = 6;
    static final String[] PALABRAS = {"JAVA", "PROGRAMACION", "COMPUTADORA", "ALGORITMO", "VARIABLE", "CODIGO", "DATOS"};

    static int juegosGanados = 0;
    static int juegosTotales = 0;
    static double puntajeTotal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== AHORCADO CONSOLA ===");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadísticas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = sc.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    jugar(sc);
                    break;
                case 2:
                    verEstadisticas();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    static int calcularMaxIntentos(String palabra) {
        int longitud = palabra.length();
        if (longitud <= 5) return 6;
        if (longitud <= 8) return 5;
        return 4;
    }

    static void revelarPista(StringBuilder mascara, String palabraSecreta) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (mascara.charAt(i) == '_') {
                mascara.setCharAt(i, palabraSecreta.charAt(i));
                System.out.println("\n💡 PISTA: Se reveló la letra en la posición " + (i + 1));
                break;
            }
        }
    }

    static void jugar(Scanner sc) {
        System.out.print("\nIngrese su nombre: ");
        String nombreJugador = sc.nextLine().trim().toUpperCase();

        while (nombreJugador.length() == 0) {
            System.out.print("Nombre inválido. Ingrese su nombre: ");
            nombreJugador = sc.nextLine().trim().toUpperCase();
        }

        String palabraSecreta = PALABRAS[(int) (Math.random() * PALABRAS.length)];
        int maxIntentos = calcularMaxIntentos(palabraSecreta);
        StringBuilder mascara = new StringBuilder();
        StringBuilder historial = new StringBuilder();
        int intentosRestantes = maxIntentos;
        int turnosTotales = 0;
        boolean juegoGanado = false;

        System.out.println("\n📏 Palabra de " + palabraSecreta.length() + " letras | Nivel: " +
                (maxIntentos == 6 ? "Fácil" : maxIntentos == 5 ? "Medio" : "Difícil"));

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == ' ') {
                mascara.append(' ');
            } else {
                mascara.append('_');
            }
        }

        System.out.println("\n¡Comienza el juego!");
        System.out.println("Palabra: " + mascara.toString());

        while (intentosRestantes > 0 && !juegoGanado) {
            if (intentosRestantes == 1) {
                System.out.println("\n⚠️ ¡Último intento! Se revelará una pista...");
                revelarPista(mascara, palabraSecreta);
            }

            System.out.println("\nIntentos restantes: " + intentosRestantes);
            System.out.println("Letras usadas: " + (historial.length() > 0 ? historial.toString() : "Ninguna"));
            System.out.print("Ingrese una letra: ");

            String entrada = sc.nextLine().trim();

            if (entrada.length() == 0) {
                System.out.println("Entrada vacía. Intente de nuevo.");
                continue;
            }

            char letra = entrada.charAt(0);
            String letraStr = String.valueOf(letra).toUpperCase();

            if (historial.toString().contains(letraStr)) {
                System.out.println("Ya usaste esa letra. Intenta con otra.");
                continue;
            }

            historial.append(letraStr).append(" ");
            turnosTotales++;
            boolean acierto = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.substring(i, i + 1).equalsIgnoreCase(letraStr)) {
                    mascara.setCharAt(i, palabraSecreta.charAt(i));
                    acierto = true;
                }
            }

            System.out.println(acierto ? "¡Acierto!" : "¡Fallo!");
            System.out.println("Palabra: " + mascara.toString());

            if (!acierto) {
                intentosRestantes--;
            }

            if (!mascara.toString().contains("_")) {
                juegoGanado = true;
            }
        }

        juegosTotales++;
        int fallosCometidos = maxIntentos - intentosRestantes;

        double puntajeBase = juegoGanado ? (intentosRestantes * 10.0) + 50 : 0;

        double multiplicador = 1.0 + ((double) intentosRestantes / maxIntentos);
        double puntajeFinal = puntajeBase * multiplicador;

        if (juegoGanado) {
            juegosGanados++;
            puntajeTotal += puntajeFinal;
            System.out.println("\n¡VICTORIA! La palabra era: " + palabraSecreta);
        } else {
            System.out.println("\n¡DERROTA! La palabra era: " + palabraSecreta);
        }

        System.out.println("\n====================================================");
        System.out.println("              RESUMEN DE LA PARTIDA");
        System.out.println("====================================================");
        System.out.printf("Jugador:           %s%n", nombreJugador);
        System.out.printf("Estado Final:      %s%n", juegoGanado ? "¡VICTORIA!" : "¡DERROTA!");
        System.out.printf("Palabra Secreta:   %s%n", palabraSecreta);
        System.out.printf("Nivel:             %s%n", maxIntentos == 6 ? "Fácil" : maxIntentos == 5 ? "Medio" : "Difícil");
        System.out.printf("Intentos Restantes: %d/%d%n", intentosRestantes, maxIntentos);
        System.out.printf("Turnos Totales:    %d%n", turnosTotales);
        System.out.printf("Fallos Cometidos:  %d%n", fallosCometidos);
        double porcentajeAciertos = turnosTotales > 0 ? ((double) (turnosTotales - fallosCometidos) / turnosTotales) * 100 : 0;
        System.out.printf("Porcentaje Aciertos: %.2f%%%n", porcentajeAciertos);
        System.out.printf("Puntaje Base:      %.2f pts%n", puntajeBase);
        System.out.printf("Multiplicador:     x%.2f%n", multiplicador);
        System.out.printf("Puntaje Final:     %.2f pts%n", puntajeFinal);
        System.out.println("====================================================");
    }

    static void verEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.printf("Juegos Totales: %d%n", juegosTotales);
        System.out.printf("Juegos Ganados: %d%n", juegosGanados);
        System.out.printf("Puntaje Total: %.2f pts%n", puntajeTotal);

        if (juegosTotales > 0) {
            double promedio = puntajeTotal / juegosTotales;
            System.out.printf("Promedio por Partida: %.2f pts%n", promedio);
        }
    }
}