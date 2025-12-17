package PracticaOpcional_RodrigoHernandezSanchez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ejercicio15HashMap {
	
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

	public static void main(String[] args)  throws IOException{
		        HashMap<String, Integer> equipos = new HashMap<>();
		        boolean salir = false;

		        do {
		            System.out.println("\n--- GESTIÓN DE VICTORIAS LOL ---");
		            System.out.println("1. Registrar equipo");
		            System.out.println("2. Registrar una victoria");
		            System.out.println("3. Mostrar victorias de cada equipo");
		            System.out.println("4. Mostrar equipo ganador");
		            System.out.println("5. Comprobar si existe un equipo");
		            System.out.println("6. Eliminar equipo");
		            System.out.println("7. Mostrar total de partidas jugadas");
		            System.out.println("8. Comprobar si hay empate");
		            System.out.println("9. Salir");

		            System.out.print("Introduce opción: ");
		            int opcion = leerIntPositivo();

		            switch (opcion) {
		                case 1: opcion1(equipos); break;
		                case 2: opcion2(equipos); break;
		                case 3: opcion3(equipos); break;
		                case 4: opcion4(equipos); break;
		                case 5: opcion5(equipos); break;
		                case 6: opcion6(equipos); break;
		                case 7: opcion7(equipos); break;
		                case 8: opcion8(equipos); break;
		                case 9: salir = true; System.out.println("Saliendo..."); break;
		                default: System.out.println("Opción no válida");
		            }

		        } while (!salir);
		 }
	
	 //case1
	 public static void opcion1(Map<String, Integer> equipos) throws IOException {
	        System.out.println("-- Registrar equipo --");
	        System.out.print("Nombre del equipo: ");
	        String nombre = leerLinea();

	        if (equipos.containsKey(nombre)) {
	            System.out.println("El equipo ya existe");
	        } else {
	            equipos.put(nombre, 0);
	            System.out.println("Equipo registrado");
	        }
	    }
	 
	//case2
	 public static void opcion2(Map<String, Integer> equipos) throws IOException {
	        System.out.println("-- Registrar victoria --");

	        if (equipos.isEmpty()) {
	            System.err.println("No hay equipos");
	            return;
	        }

	        System.out.print("Nombre del equipo: ");
	        String nombre = leerLinea();

	        if (equipos.containsKey(nombre)) {
	            int victorias = equipos.get(nombre);
	            equipos.put(nombre, victorias + 1);
	            System.out.println("Victoria registrada");
	        } else {
	            System.out.println("El equipo no existe");
	        }
	    }
	 
	//case3
	 public static void opcion3(Map<String, Integer> equipos) {
	        System.out.println("-- Victorias --");

	        if (equipos.isEmpty()) {
	            System.err.println("No hay equipos");
	            return;
	        }

	        for (Map.Entry<String, Integer> victoria : equipos.entrySet()) {
	            System.out.println(victoria.getKey() + " = " + victoria.getValue());
	        }
	    }
	 
	//case4
	 public static void opcion4(Map<String, Integer> equipos) {
	        System.out.println("-- Equipo ganador --");

	        if (equipos.isEmpty()) {
	            System.err.println("No hay equipos");
	            return;
	        }

	        String ganador = "";
	        int max = -1;

	        for (Map.Entry<String, Integer> victoria : equipos.entrySet()) {
	            if (victoria.getValue() > max) {
	                max = victoria.getValue();
	                ganador = victoria.getKey();
	            }
	        }

	        System.out.println("Ganador: " + ganador + " con " + max + " victorias");
	    }
	 
	//case5
	 public static void opcion5(Map<String, Integer> equipos) throws IOException {
	        System.out.print("Nombre del equipo: ");
	        String nombre = leerLinea();

	        if (equipos.containsKey(nombre))
	            System.out.println("El equipo existe");
	        else
	            System.out.println("El equipo no existe");
	    }
	 
	//case6
	 public static void opcion6(Map<String, Integer> equipos) throws IOException {
	        System.out.print("Nombre del equipo a eliminar: ");
	        String nombre = leerLinea();

	        if (equipos.containsKey(nombre)) {
	            equipos.remove(nombre);
	            System.out.println("Equipo eliminado");
	        } else {
	            System.err.println("El equipo no existe");
	        }
	    }
	 
	//case7
	 public static void opcion7(Map<String, Integer> equipos) {
	        int total = 0;

	        for (int victorias : equipos.values()) {
	            total += victorias;
	        }

	        System.out.println("Total de partidas: " + total);
	    }
	 
	 //case8
	 public static void opcion8(Map<String, Integer> equipos) {
	        boolean empate = false;

	        for (Map.Entry<String, Integer> e1 : equipos.entrySet()) {
	            for (Map.Entry<String, Integer> e2 : equipos.entrySet()) {
	                if (!e1.getKey().equals(e2.getKey()) && e1.getValue().equals(e2.getValue())) {
	                    empate = true;
	                }
	            }
	        }

	        if (empate) {
	            System.out.println("Hay empate");
	        }else {
	            System.out.println("No hay empate");
	        }
	    }
	}