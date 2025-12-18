package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        int cocheA = 0;
        int cocheB = 0;
        int meta = 50;

        System.out.println("=== BIENVENIDO A LA MINI CARRERA ===");
        System.out.println("¡Los coches deben llegar a 50 para ganar!");

        while (!salir) {
            System.out.println();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Avanzar coche A");
            System.out.println("2. Avanzar coche B");
            System.out.println("3. Mostrar posiciones actuales");
            System.out.println("4. Comprobar ganador");
            System.out.println("5. Simulación automática (10 turnos)");
            System.out.println("6. Reiniciar carrera");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    int avanceA = (int)(Math.random() * 10) + 1;
                    cocheA += avanceA;
                    System.out.println("=== AVANZAR COCHE A ===");
                    System.out.println("El coche A avanza " + avanceA + " metros");
                    System.out.println("Posición actual del coche A: " + cocheA);
                    break;

                case 2:
                    int avanceB = (int)(Math.random() * 10) + 1;
                    cocheB += avanceB;
                    System.out.println("=== AVANZAR COCHE B ===");
                    System.out.println("El coche B avanza " + avanceB + " metros");
                    System.out.println("Posición actual del coche B: " + cocheB);
                    break;

                case 3:
                    System.out.println("=== POSICIONES ACTUALES ===");
                    System.out.println("Coche A: " + cocheA + " metros");
                    System.out.println("Coche B: " + cocheB + " metros");
                    System.out.println("Meta: " + meta + " metros");
                    if (cocheA > cocheB) {
                        System.out.println("El coche A va ganando por " + (cocheA - cocheB) + " metros");
                    } else if (cocheB > cocheA) {
                        System.out.println("El coche B va ganando por " + (cocheB - cocheA) + " metros");
                    } else {
                        System.out.println("Ambos coches están empatados");
                    }
                    break;

                case 4:
                    System.out.println("=== COMPROBAR GANADOR ===");
                    if (cocheA >= meta && cocheB >= meta) {
                        if (cocheA > cocheB) {
                            System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE A GANA!");
                        } else if (cocheB > cocheA) {
                            System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE B GANA!");
                        } else {
                            System.out.println("¡¡¡EMPATE!!! Ambos coches llegaron a la meta");
                        }
                    } else if (cocheA >= meta) {
                        System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE A GANA!");
                    } else if (cocheB >= meta) {
                        System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE B GANA!");
                    } else {
                        System.out.println("Aún no hay ganador");
                        System.out.println("Coche A: " + cocheA + "/" + meta);
                        System.out.println("Coche B: " + cocheB + "/" + meta);
                    }
                    break;

                case 5:
                    System.out.println("=== SIMULACIÓN AUTOMÁTICA ===");
                    System.out.println("¡Iniciando carrera automática de 10 turnos!");
                    for (int turno = 1; turno <= 10; turno++) {
                        int avanceTurnoA = (int)(Math.random() * 10) + 1;
                        int avanceTurnoB = (int)(Math.random() * 10) + 1;
                        cocheA += avanceTurnoA;
                        cocheB += avanceTurnoB;
                        System.out.println("--- TURNO " + turno + " ---");
                        System.out.println("Coche A avanza " + avanceTurnoA + " → Posición: " + cocheA);
                        System.out.println("Coche B avanza " + avanceTurnoB + " → Posición: " + cocheB);
                    }
                    // Comprobar ganador al final
                    if (cocheA >= cocheB && cocheA >= meta) {
                        System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE A GANA!");
                    } else if (cocheB > cocheA && cocheB >= meta) {
                        System.out.println("¡¡¡HAY UN GANADOR!!!\n¡EL COCHE B GANA!");
                    } else {
                        System.out.println("No hay ganador tras 10 turnos");
                    }
                    break;

                case 6:
                    cocheA = 0;
                    cocheB = 0;
                    System.out.println("=== REINICIAR CARRERA ===");
                    System.out.println("¡Carrera reiniciada! Ambos coches vuelven a la posición 0");
                    break;

                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        }
    }
}
