package examenPOO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
	private int id;
	private String nombre;
	private String tipo;
	private int lvl;
	private int pSalud;
	private String [] ataques = new String[4];
    private int numAtaques = 0;
	
	public void pedirDatos(ArrayList<Pokemon> pokedex) {
        Random rand = new Random();
        int idGen;
        do {
            idGen = rand.nextInt(1025) + 1;
        } while (estaRepetido(pokedex, idGen));
        
        id = idGen;
        try {
            System.out.println("ID asignado: " + id);
            System.out.print("Nombre: ");
            
            nombre = Principal.leerLinea();  
            do {
    			System.out.print("Tipo de Pokemon (fuego/agua/planta/eléctrico): ");
    			tipo = Principal.leerLinea().toLowerCase();
    			if (!tipo.equals("fuego") && !tipo.equals("agua") && !tipo.equals("planta")&& !tipo.equals("eléctrico")) {
    				System.out.println("Error: El tipo debe ser fuego/agua/planta/eléctrico.");
    			}
    		} while (!tipo.equals("fuego") && !tipo.equals("agua") && !tipo.equals("planta")&& !tipo.equals("eléctrico"));
            
            do {
    			System.out.print("Nivel (entre 1-100): ");
    			lvl = Principal.leerInt();
    			if (lvl <= 0 || lvl >100) {
    				System.err.print("Error: ");
    				System.out.println("El nivel no cumple con los parámetros requeridos");
    			}else {
    				System.out.println("Nivel guardado");
    			}
    		} while (lvl <= 0 || lvl >100);
            
            System.out.print("Salud (PS): ");
            pSalud = Principal.leerIntPositivo();
            
        } catch (IOException e) { e.printStackTrace(); }
    }

    private boolean estaRepetido(ArrayList<Pokemon> pokedex, int idGen) {
        for (Pokemon p : pokedex) {
            if (p.getId() == idGen) return true;
        }
        return false;
    }
    
    public void mostrarTipo() throws IOException {
    	do {
			System.out.print("Tipo de Pokemon (fuego/agua/planta/eléctrico): ");
			tipo = Principal.leerLinea().toLowerCase();
			if (!tipo.equals("fuego") && !tipo.equals("agua") && !tipo.equals("planta")&& !tipo.equals("eléctrico")) {
				System.out.println("Error: El tipo debe ser fuego/agua/planta/eléctrico.");
			}
		} while (!tipo.equals("fuego") && !tipo.equals("agua") && !tipo.equals("planta")&& !tipo.equals("eléctrico"));
    }
    
    public String getTipo() { 
    	return tipo;
    	}

    
    public void añadirAtaque() {
        if (numAtaques >= 4) {
            System.out.println("No caben más ataques (Máximo 4).");
            return;
        }
        try {
            System.out.print("Nombre del ataque a añadir: ");
            ataques[numAtaques] = Principal.leerLinea();
            numAtaques++;
            System.out.println("Ataque añadido.");
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    public int getId() { 
    	return id; 
    	}
    
    public void mostrarResumen() {
        System.out.println("ID: " + id + " | " + nombre + " | Nivel: " + lvl);
        for (int i = 0; i < numAtaques; i++) {
            System.out.print("[" + ataques[i] + "] ");
        }
    }
    
    public void nivel() {
    	if(lvl > 50) {
    		System.out.println("Pokemon Fuerte");
    	}else {
    		System.out.println("Pokemon Debil");
    	}
    		return; 	
    }
    
    public void mostrarDetalle() {
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nTipo: " + tipo + "\nNivel: " + lvl + " Punto salud: " + pSalud);
        System.out.print("Ataques: ");
        for (int i = 0; i < numAtaques; i++) {
            System.out.print("[" + ataques[i] + "] ");
        }
        System.out.println("[Sin ataques]");
    }
}