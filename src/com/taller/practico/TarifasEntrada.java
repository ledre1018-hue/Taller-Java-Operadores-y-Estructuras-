package com.taller.practico;

import java.util.Locale;

public class TarifasEntrada {
    public static void main(String[] args) {
        String tipoEntrada = "VIP";
        double precioBase = 100.0;
        double precioFinal;

        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase * 1.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase * 0.60;
        } else {
            precioFinal = precioBase;
        }

        System.out.println("Tipo de entrada: " + tipoEntrada);
        System.out.println("Monto final a pagar: $" + String.format(Locale.US, "%.2f", precioFinal));
    }
}
