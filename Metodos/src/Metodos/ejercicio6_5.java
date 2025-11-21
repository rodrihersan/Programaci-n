package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6_5 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		System.out.println("=== BIENVENIDO A SIMULADOR CARRERAS  ===");
		do {
			// MOSTRAR MENU
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Avanzar coche A");
			System.out.println("2. Avanzar coche B");
			System.out.println("3. Mostrar posiciones actuales");
			System.out.println("4. Simulación automática");
			System.out.println("5. Reiniciar");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");
			int opcion = leerInt();
			
			int posicionCocheA = 0;
			int posicionCocheB = 0;
			
			switch (opcion) {
			case 1:
				posicionCocheA = avanzarCoche(posicionCocheA);
				System.out.println("El coche A ahora esta en la posicion " + posicionCocheA);
				if(haGanado(posicionCocheA))
					System.out.println("Ha ganado el coche A");
				break;
			case 2:
				posicionCocheB = avanzarCoche(posicionCocheB);
				System.out.println("El coche B ahora esta en la posicion " + posicionCocheB);
				if(haGanado(posicionCocheB))
					System.out.println("Ha ganado el coche B");
				break;
			case 3:
				mostrarPosiciones(posicionCocheA, posicionCocheB);
				break;
			case 4:
				simularCarrera(posicionCocheA, posicionCocheB);
				break;
			case 5:
				System.out.println("Carrera reiniciada");
				posicionCocheA = 0;
				posicionCocheB = 0;
				break;
			case 6:
				salir = true;
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);
	}
	
	public static int avanzarCoche(int posicion) {
		int distanciaAleatorio = (int) ((Math.random() * 10) + 1);
		posicion = posicion + distanciaAleatorio;
		return posicion;
	}
	
	public static boolean haGanado(int posicion) {
		if(posicion >= 50)
			return true;
		else
			return false;
	}
	
	public static void simularCarrera(int posicionCocheA, int posicionCocheB) {
		boolean salir = false;
		for(int i = 0; i<10 && !salir; i++) {
			System.out.println("---TURNO " + (i+1) + "----");
			posicionCocheA = avanzarCoche(posicionCocheA);
			System.out.println("El coche A ahora esta en la posicion " + posicionCocheA);
			if(haGanado(posicionCocheA)) {
				salir = true;
				System.out.println("Ha ganado el coche A");
			}
				
			posicionCocheB = avanzarCoche(posicionCocheA);
			System.out.println("El coche B ahora esta en la posicion " + posicionCocheB);
			if(haGanado(posicionCocheB)) {
				salir = true;
				System.out.println("Ha ganado el coche B");
			}
		}
	}
	
	public static void mostrarPosiciones(int posicionCocheA, int posicionCocheB) {
		System.out.println("El coche A ahora esta en la posicion " + posicionCocheA);
		System.out.println("El coche B ahora esta en la posicion " + posicionCocheB);
		
	}
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
