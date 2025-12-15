package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import java.io.InputStreamReader;

public class ejercicio12 {
	
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		Map<String, Integer> agenda = new HashMap<>();

		do {
			System.out.println("\n--- AGENDA DE TLFNS ---");
			System.out.println("1. Añadir contacto (nombre como clave, teléfono como valor)");
			System.out.println("2. Buscar teléfono por nombre");
			System.out.println("3. Mostrar todos los contactos");
			System.out.println("4. Eliminar contacto por nombre");
			System.out.println("5. Comprobar si existe un contacto");
			System.out.println("6. Modificar teléfono de un contacto existente");
			System.out.println("7. Mostrar cantidad total de contactos ");
			System.out.println("8. Salir");
			
			System.out.println("Introduce la opcion: ");
			int opcion = leerInt();

			switch (opcion) {
			case 1:opcion1(agenda);break;
			case 2:opcion2(agenda);break;
			case 3:opcion3(agenda);break;
			case 4:opcion4(agenda);break;
			case 5:opcion5(agenda);break;
			case 6:opcion6(agenda);break;
			case 7:opcion7(agenda);break;
			case 8:System.out.println("Saliendo del programa");salir = true;break;
			default:System.out.println("Opcion no valida");
			}
		}while (!salir);
	}

	// OPCION 1
	public static void opcion1(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- AÑADIR CONTACTO ---");
		
		System.out.println("Introduce el nombre del contacto para añadir: ");
		String nombre = leerLinea();
		
		System.out.println("Introduce el numero del tlfn del contacto: ");
		int telefono = leerInt();

		agenda.put(nombre, telefono);
	}

	// OPCION 2
	public static void opcion2(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- BUSCAR CONTACTO ---");

		System.out.println("Introduce un nombre de contacto para buscar: ");
		String nombre = leerLinea();

		if (agenda.getOrDefault(nombre, -1) == -1)
			System.out.println("No se ha encontrado ese nombre de contacto");
		else
			System.out.println("El tlfn de " + nombre + " es " + agenda.get(nombre));
	}

	// OPCION 3
	public static void opcion3(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- MOSTRAR TODOS LOS CONTACTOS ---");

		for (Map.Entry<String, Integer> valores : agenda.entrySet()) {
			// Con getKey me devuelve la clave, el nombre del contacto
			// Con getValue devuelve el valor, el tlfn
			System.out.println(valores.getKey() + ":" + valores.getValue());
		}
	}

	// OPCION 4
	public static void opcion4(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- ELIMINAR CONTACTO POR NOMBRE ---");

		System.out.println("Introduce un nombre de contacto para borrar: ");
		String nombre = leerLinea();
		if (agenda.remove(nombre) == null)
			System.out.println("No se ha borrado nada");
		else
			System.out.println("Contacto borrado correctamente");
	}

	// OPCION 5
	public static void opcion5(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- COMPROBAR SI EXISTE UN CONTACTO ---");

		System.out.println("Introduce un nombre de contacto para comprobar si existe: ");
		String nombre = leerLinea();
		if (agenda.containsKey(nombre))
			System.out.println("Existe el contacto en la agenda");
		else
			System.out.println("No existe");
	}

	// OPCION 6
	public static void opcion6(Map<String, Integer> agenda) throws NumberFormatException, IOException {
		System.out.println("--- MODIFICAR TLFN CONTACTO ---");

		System.out.println("Introduce un nombre de contacto para modificar: ");
		String nombre = leerLinea();

		if (agenda.containsKey(nombre)) {
			System.out.println("Introduce el numero del tlfn del contacto a modificar: ");
			int telefono = leerInt();
			agenda.put(nombre, telefono);
		} else {
			System.out.println("El contacto no existe, no se puede modificar");
		}
	}

	// OPCION 7
	public static void opcion7(Map<String, Integer> agenda) {
		System.out.println("--- CANTIDAD DE CONTACTOS ---");
		
		System.out.println("La cantidad de contactos es: " + agenda.size());
	}
}