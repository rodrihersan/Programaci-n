package ejerciciosTipoExamenWD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        double nota = -1; // -1 indica que aún no se ha introducido nota

        while (!salir) {

            System.out.println("=== BIENVENIDO AL GESTOR DE NOTAS DE EXAMEN ===");
            System.out.println();
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Introducir nota del examen");
            System.out.println("2. Comprobar si está aprobado o suspenso");
            System.out.println("3. Calcular nota con extra de participación (+0.5)");
            System.out.println("4. Comparar nota con la media del grupo");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(lector.readLine());
            System.out.println();

            switch (opcion) {

            case 1:
                System.out.println("=== INTRODUCIR NOTA ===");
                System.out.print("Introduce la nota del examen (0-10): ");
                nota = Double.parseDouble(lector.readLine());

                if (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                } else {
                    System.out.println("Nota registrada: " + nota);
                }
                System.out.println();
                break;

            case 2:
                System.out.println("=== COMPROBAR APROBADO/SUSPENSO ===");

                if (nota == -1) {
                    System.out.println("Primero debes introducir una nota.");
                } else if (nota >= 5) {
                    System.out.println("Aprobado. Tu nota es: " + nota);
                } else {
                    System.out.println("Suspenso. Tu nota es: " + nota);
                }
                System.out.println();
                break;

            case 3:
                System.out.println("=== CALCULAR CON EXTRA DE PARTICIPACIÓN ===");

                if (nota == -1) {
                    System.out.println("Primero debes introducir una nota.");
                } else {
                    double notaFinal = nota + 0.5;
                    if (notaFinal > 10) {
                        notaFinal = 10;
                    }

                    System.out.println("Nota original: " + nota);
                    System.out.println("Extra de participación: +0.5");
                    System.out.println("Nota final: " + notaFinal);
                }
                System.out.println();
                break;

            case 4:
                System.out.println("=== COMPARAR CON MEDIA DEL GRUPO ===");

                if (nota == -1) {
                    System.out.println("Primero debes introducir una nota.");
                } else {
                    System.out.print("Introduce la media del grupo: ");
                    double mediaGrupo = Double.parseDouble(lector.readLine());

                    System.out.println("Tu nota: " + nota);
                    System.out.println("Media del grupo: " + mediaGrupo);

                    double diferencia = nota - mediaGrupo;

                    if (diferencia > 0) {
                        System.out.println("Estás por encima de la media");
                        System.out.println("Diferencia: +" + diferencia + " puntos");
                    } else if (diferencia < 0) {
                        System.out.println("Estás por debajo de la media");
                        System.out.println("Diferencia: " + diferencia + " puntos");
                    } else {
                        System.out.println("Estás justo en la media del grupo");
                    }
                }
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