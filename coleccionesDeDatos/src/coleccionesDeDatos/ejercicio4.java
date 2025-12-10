package coleccionesDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio4 {
		
		//--------------------	
		public static boolean esTextoValido(String texto) throws NumberFormatException, IOException{
		    for (int i = 0; i < texto.length(); i++) {
		        char c = texto.charAt(i);

		        // comprobamos si no es letra mayúscula ni minúscula
		        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
		            return false; // encontramos un carácter no permitido
		        }
		    }
		    return true; // todos los caracteres son letras
		}
		
	//----------	
		public static String leerLinea() throws NumberFormatException, IOException{
			
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		    String texto;

		    do {
		        texto = leer.readLine().trim(); // quitamos espacios al inicio y al final

		        if (texto.length() == 0) {
		            System.err.println("Debes escribir algo.");
		            System.out.print("Inténtalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }

		        if (!esTextoValido(texto)) {
		            System.err.println("El nombre solo puede contener letras, sin números ni símbolos ni espacios en blanco.");
		            System.out.print("Inténtalo de nuevo: ");
		            continue; // vuelve al principio del bucle
		        }
		        break; // si pasa todas las comprobaciones, salimos del bucle
		    } while (true);
		    return texto;
		}
		
		public static void main(String[] args)  throws NumberFormatException, IOException {
			
			ArrayList<String> palabra = new ArrayList<>();
			
			// Pedir 7 palabras válidos
			for(int i =0;i<7;i++) {
				System.out.println("Introduce palabras: ");
				String n=leerLinea();
				palabra.add(n);
			}
			
			// Muestra el array primero
			for(String n : palabra) {
				System.out.println(n);
			}
			
			System.out.println(palabra);
			
			Collections.sort(palabra);
			
			System.out.println(palabra);
	}

}
