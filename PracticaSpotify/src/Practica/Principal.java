package Practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		do {
			System.out.println(" === SPOTIFY - GESTIÓN DE PLAYLISTS === ");
			System.out.println("1. Añadir contenido");
			System.out.println("2. Mostrar contenido por categoría ");
			System.out.println("3. Añadir contenido a playlist");
			System.out.println("4. Estadísticas del perfil.");
			System.out.println("5. Salir.");

			System.out.print("Introduce una opción: ");
			char opcion = leerLinea();
			
			switch (opcion) {
			case 1:;break;
			case 2:;break;
			case 3:;break;
			case 4:salir = true;System.out.println("Saliendo del sistema :c ");break;
			default:System.out.println("Opción no válida.");
		}	
	}while (!salir);

}
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	        // comprobamos si no es letra mayï¿½scula ni minï¿½scula
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false; // encontramos un carï¿½cter no permitido
	        }
	    }
	    return true; // todos los caracteres son letras
	}
	
	public static String leerLinea() throws IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    String texto;

	    do {
	        texto = leer.readLine().trim(); // quitamos espacios al inicio y al final

	        if (texto.length() == 0) {
	            System.err.println("Debes escribir algo.");
	            System.out.print("Intï¿½ntalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        if (!esTextoValido(texto)) {
	            System.err.println("El nombre solo puede contener letras, sin nï¿½meros ni sï¿½mbolos ni espacios en blanco.");
	            System.out.print("Intï¿½ntalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }
	        break; // si pasa todas las comprobaciones, salimos del bucle
	    } while (true);
	    return texto;
	}
}
