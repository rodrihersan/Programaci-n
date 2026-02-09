package ProyectoEEDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Principal {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		boolean salir = false;
		do {
			System.out.println(" === AMONG US === ");
			System.out.println("1. Registrar tripulante");
			System.out.println("2. Mostrar tripulantes");
			System.out.println("3. Matar (aleatorio)");
			System.out.println("4. Salir");
			System.out.print("Introduce una opción: ");
			int opcion = leerInt(leer);
			
			switch (opcion) {
			case 1:registrarJugador(jugadores);break;
			case 2:mostrarJugadores(jugadores);break;
			case 3:matar(jugadores);break;
			case 4:salir = true;System.out.println("Saliendo del sistema :c ");break;
			default:System.out.println("Opción no válida.");
		}	
	}while (!salir);
}
	
		//case1
		private static void registrarJugador(ArrayList<Jugador> jugadores) throws IOException {
			if (jugadores.size() >= 10) {
		        System.out.println("No se pueden registrar más de 10 jugadores.");
		        return;
		    }
			
			int asesinosActuales = 0;
	        for (Jugador j : jugadores) {
	            if (j.esAsesino()) 
	            	asesinosActuales++;
	        }
	        
			Jugador nuevo = new Jugador();
			nuevo.pedirDatos(leer, jugadores, asesinosActuales);
			jugadores.add(nuevo);
			System.out.println("Jugador registrado correctamente.");
			
			if (nuevo.esAsesino()) 
				System.out.println("Este jugador es asesino");
	    }
		
		//case2
		private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
			if (jugadores.isEmpty()) {
				System.out.println("No hay jugadores registrados.");
				return;
			}

			System.out.println("== Lista de jugadores ==");
			for (Jugador j : jugadores) {
				j.mostrarDatos();
			}
		}
		
		//case3
		private static void matar(ArrayList<Jugador> jugadores) {
		ArrayList<Jugador> asesinos = new ArrayList<>();
	    ArrayList<Jugador> posiblesVictimas = new ArrayList<>();

	    for (Jugador j : jugadores) {
	        if (j.esVivo()) {
	            if (j.esAsesino()) {
	                asesinos.add(j);
	            } else {
	                posiblesVictimas.add(j);
	            }
	        }
	    }

	    if (asesinos.isEmpty() || posiblesVictimas.isEmpty()) {
	        System.out.println("No se puede realizar un asesinato en este momento.");
	        return;
	    }
	    
	    Random rand = new Random();
	    
	    if (!rand.nextBoolean()) {
	        System.out.println("Esta ronda no hubo asesinato.");
	        return;
	    }
	    
	    Jugador victima = posiblesVictimas.get(rand.nextInt(posiblesVictimas.size()));
	    victima.morir();
	    System.out.println("Un tripulante ha sido asesinado...");
	}
	    
	public static int leerInt(BufferedReader leer) throws IOException {
		int num = 0;
		boolean valido = false;

		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.out.print("ERROR. Introduce un número válido: ");
			}
		}
		return num;
	}
}
