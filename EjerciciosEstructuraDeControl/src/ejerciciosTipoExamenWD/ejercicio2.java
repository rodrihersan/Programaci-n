package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;

        while (!salir) {

            System.out.println("=== BIENVENIDO A LA CALCULADORA DE ENTRADAS DE CINE ===");
            System.out.println();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Calcular precio según edad");
            System.out.println("2. Calcular precio con descuento de miércoles (50%)");
            System.out.println("3. Calcular precio con combo palomitas + refresco (+5€)");
            System.out.println("4. Calcular precio para grupo de personas");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(lector.readLine());
            System.out.println();

            switch (opcion) {

            case 1:
                System.out.println("=== CALCULAR PRECIO POR EDAD ===");
                System.out.print("Introduce tu edad: ");
                int edad = Integer.parseInt(lector.readLine());

                double precioEntrada = 0;
                String categoria = "";

                if (edad < 13) {
                    categoria = "niño";
                    precioEntrada = 5;
                } else if (edad >= 65) {
                    categoria = "jubilado";
                    precioEntrada = 6;
                } else {
                    categoria = "adulto";
                    precioEntrada = 8;
                }

                System.out.println("Categoría: " + categoria);
                System.out.println("Precio de la entrada: " + precioEntrada + "€");
                System.out.println();
                break;

            case 2:
                System.out.println("=== DESCUENTO DE MIÉRCOLES ===");
                System.out.print("Introduce el precio normal de la entrada: ");
                double precioNormal = Double.parseDouble(lector.readLine());

                double descuento = precioNormal * 0.5;
                double precioFinal = precioNormal - descuento;

                System.out.println("Precio normal: " + precioNormal + "€");
                System.out.println("Descuento del miércoles (50%): " + descuento + "€");
                System.out.println("Precio final: " + precioFinal + "€");
                System.out.println();
                break;

            case 3:
                System.out.println("=== COMBO PALOMITAS + REFRESCO ===");
                System.out.print("Introduce el precio de la entrada: ");
                double precioBase = Double.parseDouble(lector.readLine());

                double combo = 5;
                double totalCombo = precioBase + combo;

                System.out.println("Precio entrada: " + precioBase + "€");
                System.out.println("Combo palomitas + refresco: " + combo + "€");
                System.out.println("Precio total: " + totalCombo + "€");
                System.out.println();
                break;

            case 4:
                System.out.println("=== CALCULAR PRECIO PARA GRUPO ===");
                System.out.print("¿Cuántas personas van al cine? ");
                int personas = Integer.parseInt(lector.readLine());

                double totalGrupo = 0;

                for (int i = 1; i <= personas; i++) {
                    System.out.print("Edad de la persona " + i + ": ");
                    edad = Integer.parseInt(lector.readLine());

                    if (edad < 13) {
                        precioEntrada = 5;
                        categoria = "niño";
                    } else if (edad >= 65) {
                        precioEntrada = 6;
                        categoria = "jubilado";
                    } else {
                        precioEntrada = 8;
                        categoria = "adulto";
                    }

                    System.out.println("Persona " + i + " (" + categoria + "): " + precioEntrada + "€");
                    totalGrupo += precioEntrada;
                }

                System.out.println("--- RESUMEN DEL GRUPO ---");
                System.out.println("Total de personas: " + personas);
                System.out.println("Precio total: " + totalGrupo + "€");
                System.out.println();
                break;

            case 5:
                System.out.println("¡Hasta luego!");
                salir = true;
                break;

            default:
                System.out.println("Opción inválida");
                System.out.println();
            }
        }
    }
}