package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;

        do {
            System.out.println("=== AMONG US ===");
            System.out.println("Opción 1: Registrar nuevo jugador");
            System.out.println("Opción 2: Registrar una nueva partida");
            System.out.println("Opción 3: Ver estadísticas de un jugador");
            System.out.println("Opción 4: Exportar informe de partidas");
            System.out.println("Opción 5: Salir");
            System.out.print("Introduce una opción: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.err.println("Solo puedes introducir números.");
                }
            }

            switch (opcion) {
                case 1:System.out.println("-- Nuevo jugador --");registrarJugador();break;
                case 2:System.out.println("-- Nueva partida --");nuevaPartida();break;
                //case 3:System.out.println("-- Estadísticas jugador --");estadisticas();break;
                //case 4:System.out.println("-- Exportar informe --");exportarInforme();break;
                case 5:System.out.println("Saliendo del programa. ¡Hasta pronto!");salir = true;break;
                default:System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
            }

        } while (!salir);
    }
    
    public static void registrarJugador() throws IOException {
    	Jugador jugador = new Jugador();
    	jugador.pedirDatos();
    	jugador.escribirFichero();
    }
    
    public static void nuevaPartida() {
    	
    }
    }
    