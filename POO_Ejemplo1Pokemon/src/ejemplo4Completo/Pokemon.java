package ejemplo4Completo;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int xp;
    // ARRAY NORMAL PARA ATAQUES
    private String[] ataques = new String[4]; 
    private int numAtaques = 0;

    public void pedirDatos(ArrayList<Pokemon> pokedex) {
        Random rand = new Random();
        int idGen;
        do {
            idGen = rand.nextInt(50) + 1;
        } while (estaRepetido(pokedex, idGen));
        
        id = idGen;
        try {
            System.out.println("ID asignado: " + id);
            System.out.print("Nombre: ");
            nombre = Principal.leerLinea(); 
            System.out.print("Tipo: ");
            tipo = Principal.leerLinea(); 
            nivel = 1;
            xp = 0;
        } catch (IOException e) { e.printStackTrace(); }
    }

    private boolean estaRepetido(ArrayList<Pokemon> pokedex, int idGen) {
        for (Pokemon p : pokedex) {
            if (p.getId() == idGen) return true;
        }
        return false;
    }

    public void añadirAtaque() {
        if (numAtaques >= 4) {
            System.out.println("No caben más ataques (Máximo 4).");
            return;
        }
        try {
            System.out.print("Nombre del ataque: ");
            ataques[numAtaques] = Principal.leerLinea();
            numAtaques++;
            System.out.println("Ataque añadido.");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void eliminarAtaque() {
        try {
            System.out.print("Nombre del ataque a borrar: ");
            String borrar = Principal.leerLinea();
            for (int i = 0; i < numAtaques; i++) {
                if (ataques[i].equalsIgnoreCase(borrar)) {
                    // Desplazamiento manual porque es un array normal
                    for (int j = i; j < numAtaques - 1; j++) {
                        ataques[j] = ataques[j + 1];
                    }
                    numAtaques--;
                    System.out.println("Ataque borrado.");
                    return;
                }
            }
            System.out.println("Ataque no encontrado.");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void darXP() {
        try {
            System.out.print("Cantidad de XP: ");
            int cantidad = Principal.leerIntPositivo(); 
            xp += cantidad;
            while (xp >= 100) {
                nivel++;
                xp -= 100;
                System.out.println("¡Subida al nivel " + nivel + "!");
            }
        } catch (Exception e) { System.out.println("Error al dar XP."); }
    }

    public void mostrarResumen() {
        System.out.println("ID: " + id + " | " + nombre + " | Nivel: " + nivel);
    }

    public void mostrarDetalle() {
        System.out.println("--- FICHA POKEMON ---");
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nTipo: " + tipo + "\nNivel: " + nivel + " (XP: " + xp + "/100)");
        System.out.print("Ataques: ");
        for (int i = 0; i < numAtaques; i++) {
            System.out.print("[" + ataques[i] + "] ");
        }
        System.out.println("\n---------------------");
    }

    public boolean conoceAtaque(String a) {
        for (int i = 0; i < numAtaques; i++) {
            if (ataques[i].equalsIgnoreCase(a)) return true;
        }
        return false;
    }

    public void limpiarAtaques() {
        for (int i = 0; i < ataques.length; i++) ataques[i] = null;
        numAtaques = 0;
        System.out.println("Ataques borrados.");
    }

    public void evolucionar() {
        if (nivel >= 20) {
            nombre = "MEGA " + nombre;
            System.out.println("¡Evolucionado!");
        } else { System.out.println("Nivel insuficiente."); }
    }

    public int getId() { return id; }
    public int getNivel() { return nivel; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
}