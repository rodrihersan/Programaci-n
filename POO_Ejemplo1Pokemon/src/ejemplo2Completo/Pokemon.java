package ejemplo2Completo;

import java.io.*;
import java.util.Random;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int xp;
    private String[] ataques = new String[4]; // Array interno fijo
    private int numAtaques = 0;

    public void pedirDatos(Pokemon[] pokedex, int cont) {
        Random rand = new Random();
        int idGen;
        // Generar ID que no esté en el array del Main
        do {
            idGen = rand.nextInt(50) + 1;
        } while (estaRepetido(pokedex, cont, idGen));
        
        this.id = idGen;
        try {
            System.out.println("ID asignado: " + id);
            System.out.print("Nombre: ");
            // USAMOS LA VALIDACIÓN DE LETRAS
            this.nombre = Principal.leerLinea(); 
            System.out.print("Tipo: ");
            this.tipo = Principal.leerLinea(); 
            this.nivel = 1;
            this.xp = 0;
        } catch (IOException e) { e.printStackTrace(); }
    }

    private boolean estaRepetido(Pokemon[] pokedex, int cont, int idGen) {
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == idGen) return true;
        }
        return false;
    }

    public void añadirAtaque() {
        if (numAtaques >= ataques.length) {
            System.out.println("No caben más ataques.");
            return;
        }
        try {
            System.out.print("Nombre del ataque: ");
            // VALIDACIÓN DE TEXTO PARA ATAQUE
            ataques[numAtaques] = Principal.leerLinea(); 
            numAtaques++;
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void eliminarAtaque() {
        try {
            System.out.print("Nombre del ataque a borrar: ");
            String borrar = Principal.leerLinea();
            for (int i = 0; i < numAtaques; i++) {
                if (ataques[i].equalsIgnoreCase(borrar)) {
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
            // USAMOS TU VALIDACIÓN DE NÚMEROS
            int cantidad = Principal.leerIntPositivo(); 
            this.xp += cantidad;
            while (this.xp >= 100) {
                this.nivel++;
                this.xp -= 100;
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
        for (int i = 0; i < numAtaques; i++) System.out.print("[" + ataques[i] + "] ");
        System.out.println("\n---------------------");
    }

    public boolean conoceAtaque(String a) {
        for (int i = 0; i < numAtaques; i++) {
            if (ataques[i].equalsIgnoreCase(a)) return true;
        }
        return false;
    }
    public String getTipo() { 
        return tipo; 
    }

    public void limpiarAtaques() {
        for (int i = 0; i < ataques.length; i++) ataques[i] = null;
        this.numAtaques = 0;
        System.out.println("Ataques borrados.");
    }

    public void evolucionar() {
        if (this.nivel >= 20) {
            this.nombre = "MEGA " + this.nombre;
            System.out.println("¡Evolucionado!");
        } else {
            System.out.println("Nivel insuficiente.");
        }
    }

    public int getId() { return id; }
    public int getNivel() { return nivel; }
    public String getNombre() { return nombre; }
}