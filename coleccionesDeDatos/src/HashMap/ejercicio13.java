package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import java.io.InputStreamReader;

public class ejercicio13 {
	
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
		Map<String, String> traduccion = new HashMap<>();

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
			case 1:opcion1(traduccion);break;
			case 2:opcion2(traduccion);break;
			case 3:opcion3(traduccion);break;
			case 4:opcion4(traduccion);break;
			case 5:opcion5(traduccion);break;
			case 6:opcion6(traduccion);break;
			case 7:opcion7(traduccion);break;
			case 8:System.out.println("Saliendo del programa");salir = true;break;
			default:System.out.println("Opcion no valida");
			}
		}while (!salir);
	}
	
	public static void opcion1(Map<String, String> traduccion) throws NumberFormatException, IOException {
		System.out.println("--Añadir palabra y su traducción--");
		
		System.out.println("Introduce una palabra: ");
		String palabra = leerLinea();
		System.out.println("Introduce la palabra traducida: ");
		String palabraTraducida = leerLinea();
		
		traduccion.put(palabra, palabraTraducida);
		
	}
	
	public static void opcion2(Map<String, String> traduccion) throws NumberFormatException, IOException {
		System.out.println("-- Buscar traducción de una palabra -- ");
		
		System.out.println("Introduce una palabra a buscar: ");
		String palabraABuscar = leerLinea();
		
		if(traduccion.containsKey(palabraABuscar))
			System.out.println("La traduccion de " + palabraABuscar + " es " + traduccion.get(palabraABuscar));
		else
			System.out.println("Palabra no encontrada");
	}
	
	public static void opcion3(Map<String, String> traduccion) throws NumberFormatException, IOException {
		System.out.println("-- Buscar traducción de una palabra con getOrDefault -- ");
		
		System.out.println("Introduce una palabra a buscar: ");
		String palabraABuscar = leerLinea();
		
		System.out.println("La traduccion de " + palabraABuscar + " es " 
				+ traduccion.getOrDefault(palabraABuscar, "Traduccion No Disponible"));
	}
	
	public static void opcion4(Map<String, String> traduccion) {
		System.out.println("-- Mostrar todo el diccionario -- ");
		
		for (Map.Entry<String, String> valores : traduccion.entrySet()) {
			System.out.println(valores.getKey() + " -- " + valores.getValue());
		}

	}
	
	public static void opcion5(Map<String, String> traduccion) throws NumberFormatException, IOException {
		System.out.println("-- Eliminar una palabra del diccionario -- ");
	
		System.out.println("Introduce una palabra para eliminar: ");
		String palabraAEliminar = leerLinea();
		
		if(traduccion.containsKey(palabraAEliminar)) {
			traduccion.remove(palabraAEliminar);
			System.out.println("Se ha eliminado correctamente");
		}else {
			System.out.println("Palabra no encontrada");
		}

	}
	
	public static void opcion6(Map<String, String> traduccion) {
		System.out.println("-- Contar total de palabras en el diccionario -- ");
		
		System.out.println("Hay " + traduccion.size() + " palabras");
	}
	
	public static void opcion7(Map<String, String> traduccion) {
		System.out.println("-- Mostrar todas las palabras en español (solo claves) -- ");
		
		for(String clave: traduccion.keySet()) {
			System.out.println(clave);
		}
	}
	
	public static void opcion8(Map<String, String> traduccion) {
		System.out.println("-- Mostrar todas las traducciones (solo valores) -- ");
		
		for(String valores: traduccion.values()) {
			System.out.println(valores);
		}
	}
}