package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        double saldo = 0;

        while (!salir) {

            System.out.println("=== BIENVENIDO A TU CUENTA BANCARIA ===");
            System.out.println();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar saldo actual");
            System.out.println("4. Comprobar si puedes comprar videojuego (60€)");
            System.out.println("5. Simular ahorro mensual");
            System.out.println("6. Salir");
            System.out.println();
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(lector.readLine());
            System.out.println();

            switch (opcion) {

            case 1:
                System.out.println("=== INGRESAR DINERO ===");
                System.out.print("Introduce la cantidad a ingresar: ");
                double ingreso = Double.parseDouble(lector.readLine());

                saldo += ingreso;

                System.out.println("Has ingresado " + ingreso + "€");
                System.out.println("Tu nuevo saldo es: " + saldo + "€");
                System.out.println();
                break;

            case 2:
                System.out.println("=== RETIRAR DINERO ===");
                System.out.print("Introduce la cantidad a retirar: ");
                double retirada = Double.parseDouble(lector.readLine());

                if (retirada <= saldo) {
                    saldo -= retirada;
                    System.out.println("Has retirado " + retirada + "€");
                    System.out.println("Tu nuevo saldo es: " + saldo + "€");
                } else {
                    System.out.println("No tienes suficiente saldo.");
                    System.out.println("Saldo disponible: " + saldo + "€");
                }
                System.out.println();
                break;

            case 3:
                System.out.println("=== CONSULTAR SALDO ===");
                System.out.println("Tu saldo actual es: " + saldo + "€");
                System.out.println();
                break;

            case 4:
                System.out.println("=== COMPRAR VIDEOJUEGO ===");
                double precioJuego = 60;

                if (saldo >= precioJuego) {
                    System.out.println("¡Puedes comprar el videojuego!");
                    System.out.println("Precio videojuego: " + precioJuego + "€");
                    System.out.println("Tu saldo: " + saldo + "€");
                } else {
                    System.out.println("No tienes suficiente dinero para el videojuego");
                    System.out.println("Precio videojuego: " + precioJuego + "€");
                    System.out.println("Tu saldo: " + saldo + "€");
                    System.out.println("Te faltan: " + (precioJuego - saldo) + "€");
                }
                System.out.println();
                break;

            case 5:
                System.out.println("=== SIMULAR AHORRO MENSUAL ===");
                System.out.print("¿Cuánto quieres ahorrar cada mes? ");
                double ahorroMensual = Double.parseDouble(lector.readLine());

                System.out.print("¿Para cuántos meses? ");
                int meses = Integer.parseInt(lector.readLine());

                double saldoSimulado = saldo;
                double totalAhorrado = 0;

                System.out.println("--- SIMULACIÓN DE AHORRO ---");

                for (int i = 1; i <= meses; i++) {
                    saldoSimulado += ahorroMensual;
                    totalAhorrado += ahorroMensual;
                    System.out.println("Mes " + i + ": " + saldoSimulado + "€");
                }

                System.out.println("Resumen:");
                System.out.println("Saldo actual: " + saldo + "€");
                System.out.println("Total ahorrado en " + meses + " meses: " + totalAhorrado + "€");
                System.out.println("Saldo final proyectado: " + saldoSimulado + "€");
                System.out.println();
                break;

            case 6:
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