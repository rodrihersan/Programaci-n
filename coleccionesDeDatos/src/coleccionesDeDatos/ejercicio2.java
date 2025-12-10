package coleccionesDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio2 {

	public static int leerInt() throws IOException {
		 
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un número válido: ");
			}
		}
		return num;
	}
	
//--------------------	
	public static int leerIntPositivo() throws IOException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El número no puede ser negativo. Intentalo de nuevo: ");
	        numero = leerInt();
	    }
	    return numero;
	}
	
//--------------------	
	public static boolean esTextoValido(String texto) {
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
	public static String leerLinea() throws IOException {
		
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
	public static void main(String[] args) throws IOException{
		
		ArrayList<String> nombre = new ArrayList<>();
		
		// Pedir 6 nombres válidos
		for(int i =0;i<6;i++) {
			System.out.println("Introduce un nombre: ");
			String n=leerLinea();
			nombre.add(n);
		}
		
		// Muestra el array primero
		for(String n : nombre) 
			System.out.println(n);
		
		int posicion =-1;
		do {
		System.out.println("Introduce una posicion: ");
		posicion = leerIntPositivo();
		}while(posicion <0 && posicion >6);
		
		for(String n : nombre) {
			System.out.println(nombre + " ");
		}
		System.out.println("");
		
		nombre.remove(posicion);
		
		for(String n : nombre) {
			System.out.println(n + " ");
		}
	}
}
