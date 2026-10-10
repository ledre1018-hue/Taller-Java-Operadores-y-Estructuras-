package com.taller.practico;

import java.util.Locale;

public class SimuladorCajaInventario {
    public static void main(String[] args) {
        facturar(3, "VIP", "PROMO1 año");
        facturar(1, "NUEVO", "PROMO1 año");
    }

    static void facturar(int cantidad, String tipoCliente, String cupon) {
        double subtotalBase = cantidad * 250.00;

        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP"     -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO"   -> 0.05;
            default        -> 0.0;
        };

        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;

        double descuentoCupon = 0.0;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double totalFinal = baseImponible + iva;

        System.out.println("── Factura ──");
        System.out.println("Cantidad: " + cantidad + " | Cliente: " + tipoCliente + " | Cupón: " + cupon);
        System.out.println("Subtotal base: $" + String.format(Locale.US, "%.2f", subtotalBase));
        System.out.println("Descuento cliente (" + (porcentajeDescuento * 100) + "%): -$" + String.format(Locale.US, "%.2f", descuentoCliente));
        System.out.println("Subtotal con descuento: $" + String.format(Locale.US, "%.2f", subtotalConDescuento));
        System.out.println("Descuento cupón: -$" + String.format(Locale.US, "%.2f", descuentoCupon));
        System.out.println("Base imponible: $" + String.format(Locale.US, "%.2f", baseImponible));
        System.out.println("IVA (16%): $" + String.format(Locale.US, "%.2f", iva));
        System.out.println("Total a pagar = $" + String.format(Locale.US, "%.2f", totalFinal));
        System.out.println();
    }
}
