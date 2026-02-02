package examenPOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
    static ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws IOException{
	boolean salir = false;
    do {
        System.out.println(" ______________________________________________________________ ");
        System.out.println("|                        MENU POKÉMON                          |");
        System.out.println("|______________________________________________________________|");
        System.out.println("| 1. Registrar Pokémon					                       |");
        System.out.println("| 2. Mostrar todos  						                   |");
        System.out.println("| 3. Gestion de ataques					                       |");
        System.out.println("| 4. Salir								                       |");
        System.out.println("|______________________________________________________________|");
        
        System.out.print(" Elige una opción: ");
        int opc = leerIntPositivo();
        
        switch (opc) {
        	case 1: registrar(); break;
        	case 2: filtrarPorTipo(); break;
        	case 3: gestionAtaques();break;
        	case 4: salir = true; break;
        }
        
    } while (!salir);
	}
	
	
	
	private static void registrar() {
		System.out.println(" ______________________________________________________________ ");
        System.out.println("|                   Registrar Pokemons                         |");
        System.out.println("|______________________________________________________________|");
        Pokemon p = new Pokemon();
        p.pedirDatos(pokedex);
        pokedex.add(p);
    }
	
	private static void filtrarPorTipo() throws IOException {
		System.out.println(" ______________________________________________________________ ");
        System.out.println("|                  BÚSQUEDA POR TIPO                           |");
        System.out.println("|______________________________________________________________|");
        System.out.print("Tipo: ");
        String t = leerLinea();
        for (Pokemon p : pokedex) {
            if (p.getTipo().equalsIgnoreCase(t)){
            	p.mostrarDetalle();
            	p.nivel();
            	
            }else { 
            	System.out.println("Datos sin añadir");
            }
        }
    }
	
	private static void gestionAtaques() throws IOException {
		System.out.println(" ______________________________________________________________ ");
        System.out.println("|                    ENTRENAR POKÉMON                          |");
        System.out.println("|______________________________________________________________|");
		System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { 
            	p.mostrarDetalle();
            	p.añadirAtaque(); return; }
        }
        System.out.println("ID no encontrada.");
	}      	
    
	
    public static int leerInt() throws IOException {
        int num = 0;
        boolean valido = false;
        while (!valido) {
            try {
                num = Integer.parseInt(leer.readLine());
                valido = true;
            } catch (Exception e) { System.err.print("Número inválido: "); }
        }
        return num;
    }
    
    public static int leerIntPositivo() throws IOException {
        int num = leerInt();
        while (num < 0) { 
        	System.err.print("Dato invalido: No puede tener valor negativo"); 
        	num = leerInt(); 
        }
        return num;
    }
    
    public static String leerLinea() throws IOException {
        String texto;
        do {
            texto = leer.readLine().trim();
            if (texto.length() > 0 && esTextoValido(texto)) break;
            System.err.print("No puede contener numeros el nombre.");
        } while (true);
        return texto;
    }
    
    public static boolean esTextoValido(String t) {
        for (char c : t.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }
}
