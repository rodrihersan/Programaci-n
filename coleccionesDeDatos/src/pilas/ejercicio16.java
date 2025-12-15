package pilas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.io.InputStreamReader;
import java.io.InputStreamReader;

public class ejercicio16 {
	
	public static int leerInt() throws NumberFormatException, IOException {
		 
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
	public static double leerDouble() throws NumberFormatException, IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double numero =0;
		boolean valido=false;
		
		while(!valido) {
			try {
				numero = Double.parseDouble(leer.readLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.err.print("ERROR. ");
	            System.out.println("Introduce un número válido");
	        }
	    }
	    return numero;
		}

//--------------------		
	public static double leerDoublePositivo() throws NumberFormatException, IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un número negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
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
	public static String leerLinea() throws NumberFormatException, IOException {
		
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

	public static void main(String[] args) throws NumberFormatException, IOException{
		boolean salir = false;
		Stack<Double> resultados = new Stack<>();
		
		do {
			System.out.println("\n--- SISTEMA DE TRADUCCION DE PALABRAS  ---");
			System.out.println("1. Añadir palabra y su traducción");
			System.out.println("2. Buscar traducción de una palabra");
			System.out.println("3. Buscar traducción con getOrDefault");
			System.out.println("4.  Mostrar todo el diccionario");
			System.out.println("5.  Eliminar una palabra del diccionario");
			System.out.println("6.  Contar total de palabras en el diccionario");
			System.out.println("7.  Mostrar todas las palabras en español (solo claves) ");
			System.out.println("8. Mostrar todas las traducciones (solo valores)");
			System.out.println("9. Salir");
			
			System.out.println("Introduce la opcion: ");
			int opcion = leerIntPositivo();

			switch (opcion) {
			case 1:opcion1(resultados);break;
			case 2:opcion2(resultados);break;
			case 3:opcion3(resultados);break;
			case 4:opcion4(resultados);break;
			case 5:opcion5(resultados);break;
			case 6:opcion6(resultados);break;
			case 7:System.out.println("Saliendo del programa");salir = true;break;
			default:System.out.println("Opcion no valida");
			}
		}while (!salir);
	}
	public static void opcion1(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("--Realizar operación--");

		System.out.println("Introduce la operacion a realizar (+,-,*,/): ");
		char operacion = leerLinea().charAt(0);
		
		System.out.println("Introduce el numero 1 a realizar la operacion ");
		double numero1 = leerDouble();
		
		System.out.println("Introduce el numero 1 a realizar la operacion ");
		double numero2 = leerDouble();

		double resultado = -1;
		switch (operacion) {
		case '+':resultado = numero1 + numero2;break;
		case '-':resultado = numero1 - numero2;break;
		case '*':resultado = numero1 * numero1;break;
		case '/':resultado = numero1 / numero1;break;
		default:System.out.println("Operacion no valida");}

		if(resultado != -1)
			resultados.push(resultado);
	}
	
	public static void opcion2(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("-- Ver último resultado --");
		
		System.out.println("El ultimo resultado es " + resultados.peek());
		
	}
	
	public static void opcion3(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("-- Recuperar y eliminar último resultado --");
		
		System.out.println("El ultimo resultado es " + resultados.pop());
		
	}
	
	public static void opcion4(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("-- Mostrar todo el historial --");
		
		for(Double valor: resultados) {
			System.out.println(valor);
		}
	}
	
	public static void opcion5(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("-- Limpiar historial --");
		
		resultados.clear();
		System.out.println("Se ha borrado todo correctamente");
	}
	
	public static void opcion6(Stack<Double> resultados) throws NumberFormatException, IOException {
		System.out.println("-- Mostrar cantidad de operaciones realizadas --");
		
		System.out.println(resultados.size());
	}
}