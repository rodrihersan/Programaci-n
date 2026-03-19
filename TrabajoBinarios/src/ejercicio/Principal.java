package ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;

        do {
            System.out.println("=== AMONG US ===");
            System.out.println("1. Nuevo jugador");
            System.out.println("2. Nueva partida");
            System.out.println("3. Estadísticas jugador");
            System.out.println("4. Exportar informe");
            System.out.println("5. Salir");
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
                case 1:System.out.println("-- Nuevo jugador --");nuevoJugador();break;
                case 2:System.out.println("-- Nueva partida --");nuevaPartida();break;
                //case 3: System.out.println("-- Estadísticas jugador --");estadisticas();break;
                //case 4:System.out.println("-- Exportar informe --");exportarInforme();break;
                case 5:System.out.println("Saliendo del programa. ¡Hasta pronto!");salir = true;break;
                default:System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
            }

        } while (!salir);
    }

    //case1
    private static void nuevoJugador() {
        Jugador jugador = new Jugador();
        jugador.pedirDatos();
        jugador.escribirFichero();
    }

    //case2
    private static void nuevaPartida() {
        Partida partida = new Partida();
        partida.pedirDatos();
        partida.guardarPartida();

        Jugador impostor = Jugador.buscarPorId(partida.getIdImpostor());
        if (impostor != null) {
            impostor.setPartidas(impostor.getPartidas() + 1);
            if (partida.isVictoriaImpostor()) {
                impostor.setPuntos(impostor.getPuntos() + 150);
                System.out.println("El impostor ha ganado. +150 puntos.");
            } else {
                impostor.setPuntos(impostor.getPuntos() + 50);
                System.out.println("El impostor ha perdido. +50 puntos.");
            }
            Jugador.actualizarJugador(impostor);
            System.out.println("Jugador actualizado correctamente.");
        }
    }
}