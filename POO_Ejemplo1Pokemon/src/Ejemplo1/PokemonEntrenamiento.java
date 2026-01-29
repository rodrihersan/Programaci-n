package Ejemplo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PokemonEntrenamiento {
    private int id;
    private String nombre;
    private String especie;
    private double[] puntuaciones = new double[5];
    private int numPuntuaciones;

    public void pedirDatos(ArrayList<PokemonEntrenamiento> equipo) throws IOException {
        Random rand = new Random();
        int idGenerado;
        do {
            idGenerado = rand.nextInt(6) + 1;
        } while (estaRepetido(equipo, idGenerado));

        id = idGenerado;
        System.out.println("ID Pokedex asignado: " + id);

        System.out.print("Introduce el mote del Pokémon: ");
        nombre = leerLinea();
        
        System.out.print("Introduce la especie: ");
        especie = leerLinea();
        
        numPuntuaciones = 0;
    }

    public void añadirPuntuacion() {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        if (numPuntuaciones >= 6) {
            System.out.println("Historial lleno.");
            return;
        }
        try {
            System.out.print("Introduce puntuación (0-10): ");
            double nota = Double.parseDouble(leer.readLine());
            if (nota >= 0 && nota <= 10) {
                puntuaciones[numPuntuaciones] = nota;
                numPuntuaciones++;
            } else {
                System.out.println("Puntuación fuera de rango.");
            }
        } catch (Exception e) {
            System.out.println("Error en el formato del número.");
        }
    }

    public void verCalificaciones() {
        if (numPuntuaciones > 0) {
            System.out.println("Pokémon: " + nombre + " (" + especie + ")");
            double min = 11, max = -1;
            for (int i = 0; i < numPuntuaciones; i++) {
                System.out.print("[" + puntuaciones[i] + "] ");
                if (puntuaciones[i] < min) min = puntuaciones[i];
                if (puntuaciones[i] > max) max = puntuaciones[i];
            }
            System.out.println("\nMáxima: " + max + " | Mínima: " + min);
        } else {
            System.out.println(nombre + " no tiene registros.");
        }
    }

    public double devolverMedia() {
        if (numPuntuaciones == 0) return 0;
        double suma = 0;
        for (int i = 0; i < numPuntuaciones; i++) suma += puntuaciones[i];
        return suma / numPuntuaciones;
    }

    public static String leerLinea() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        do {
            texto = leer.readLine().trim();
            if (texto.length() == 0) {
                System.err.print("Debes escribir algo: ");
                continue;
            }
            if (!esTextoValido(texto)) {
                System.err.print("Solo letras: ");
                continue;
            }
            break;
        } while (true);
        return texto;
    }

    public static boolean esTextoValido(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) return false;
        }
        return true;
    }

    private boolean estaRepetido(ArrayList<PokemonEntrenamiento> equipo, int idBusca) {
        for (PokemonEntrenamiento p : equipo) {
            if (p.getId() == idBusca) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " (" + especie + ")";
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double[] getPuntuaciones() { return puntuaciones; }
    public int getNumPuntuaciones() { return numPuntuaciones; }
}