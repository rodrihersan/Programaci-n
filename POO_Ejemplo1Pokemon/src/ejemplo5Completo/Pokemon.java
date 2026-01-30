package ejemplo5Completo;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int xp;
    // ATAQUES COMO ARRAYLIST
    private ArrayList<String> ataques = new ArrayList<String>(); 

    public void pedirDatos(Pokemon[] pokedex, int cont) {
        Random rand = new Random();
        int idGen;
        do {
            idGen = rand.nextInt(50) + 1;
        } while (estaRepetido(pokedex, cont, idGen));
        
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

    private boolean estaRepetido(Pokemon[] pokedex, int cont, int idGen) {
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == idGen) return true;
        }
        return false;
    }

    public void añadirAtaque() {
        // En ArrayList el límite lo pones tú (ej: 4)
        if (ataques.size() >= 4) {
            System.out.println("No caben más ataques.");
            return;
        }
        try {
            System.out.print("Nombre del ataque: ");
            ataques.add(Principal.leerLinea());
            System.out.println("Ataque añadido.");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void eliminarAtaque() {
        try {
            System.out.print("Nombre del ataque a borrar: ");
            String borrar = Principal.leerLinea();
            // ArrayList borra por nombre y desplaza solo
            if (ataques.remove(borrar)) {
                System.out.println("Ataque borrado.");
            } else {
                System.out.println("Ataque no encontrado.");
            }
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
        } catch (Exception e) { System.out.println("Error."); }
    }

    public void mostrarResumen() {
        System.out.println("ID: " + id + " | " + nombre + " | Nivel: " + nivel);
    }

    public void mostrarDetalle() {
        System.out.println("--- FICHA POKEMON (ATAQUES ARRAYLIST) ---");
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nTipo: " + tipo + "\nNivel: " + nivel);
        System.out.print("Ataques: ");
        for (String atq : ataques) {
            System.out.print("[" + atq + "] ");
        }
        System.out.println("\n---------------------");
    }

    public boolean conoceAtaque(String a) {
        for (String atq : ataques) {
            if (atq.equalsIgnoreCase(a)) return true;
        }
        return false;
    }

    public void limpiarAtaques() {
        ataques.clear();
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