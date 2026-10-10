package com.taller.practico;

public class ClasificacionEdades {
    public static void main(String[] args) {
        int edadUsuario = 28;

        if (edadUsuario < 12) {
            System.out.println("Categoría: Infante — requiere tutor de cuenta.");
        } else if (edadUsuario <= 17) {
            System.out.println("Categoría: Adolescente — acceso restringido a foros comunitarios.");
        } else if (edadUsuario <= 64) {
            System.out.println("Categoría: Adulto — acceso a funcionalidades estándar.");
        } else {
            System.out.println("Categoría: Adulto Mayor — acceso con interfaz adaptada.");
        }
    }
}
