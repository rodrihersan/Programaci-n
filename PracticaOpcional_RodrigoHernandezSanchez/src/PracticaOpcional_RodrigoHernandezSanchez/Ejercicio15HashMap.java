package PracticaOpcional_RodrigoHernandezSanchez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import java.io.InputStreamReader;

public class Ejercicio15HashMap {
	
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
				System.out.println("Introduce un n�mero v�lido: ");
			}
		}
		return num;
	}
	
//--------------------	
	public static int leerIntPositivo() throws IOException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El n�mero no puede ser negativo. Intentalo de nuevo: ");
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
	            System.out.println("Introduce un n�mero v�lido");
	        }
	    }
	    return numero;
		}

//--------------------		
	public static double leerDoublePositivo() throws NumberFormatException, IOException {
        double numero = leerDouble();
        while (numero < 0) {
        	System.err.print("No puedes introducir un n�mero negativo.");
        	System.out.println(" Intentalo de nuevo: ");
            numero = leerDouble();
        }
        return numero;
    }
	
//--------------------			
	public static boolean esTextoValido(String texto) {
	    for (int i = 0; i < texto.length(); i++) {
	        char c = texto.charAt(i);

	        // comprobamos si no es letra may�scula ni min�scula
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
	            return false; // encontramos un car�cter no permitido
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
	            System.out.print("Int�ntalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }

	        if (!esTextoValido(texto)) {
	            System.err.println("El nombre solo puede contener letras, sin n�meros ni s�mbolos ni espacios en blanco.");
	            System.out.print("Int�ntalo de nuevo: ");
	            continue; // vuelve al principio del bucle
	        }
	        break; // si pasa todas las comprobaciones, salimos del bucle
	    } while (true);
	    return texto;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean salir = false;
        Map<String, Integer> equipos = new HashMap<>();

        do {
            System.out.println("\n--- GESTIÓN DE VICTORIAS DE EQUIPOS LOL ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar una victoria");
            System.out.println("3. Mostrar victorias actuales");
            System.out.println("4. Mostrar equipo ganador");
            System.out.println("5. Comprobar si existe un equipo");
            System.out.println("6. Eliminar equipo");
            System.out.println("7. Mostrar total de partidas jugadas");
            System.out.println("8. Mostrar porcentaje de victorias de cada equipo");
            System.out.println("9. Comprobar si hay empate");
            System.out.println("10. Salir");

            System.out.print("Introduce la opción: ");
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
                case 9: opcion9(equipos); break;
                case 10: System.out.println("Saliendo del programa"); salir = true; break;
                default: System.out.println("Opción no válida"); break;
            }
        } while (!salir);
    }
	
	//Case1
	 public static void opcion1(Map<String, Integer> equipos) throws IOException {
	        System.out.println("\n-- Registrar equipo --");
	        System.out.print("Introduce el nombre del equipo: ");
	        String equipo = leerLinea();

	        if (equipos.containsKey(equipo)) {
	            System.out.println("El equipo ya está registrado.");
	        } else {
	            equipos.put(equipo, 0);
	            System.out.println("Equipo registrado con 0 victorias.");
	        }
	    }
	 
	 //case2
	 public static void opcion2(Map<String, Integer> equipos) throws IOException {
	        System.out.println("-- Registrar victoria --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }

	        System.out.print("Introduce el nombre del equipo que ganó: ");
	        String equipo = leerLinea();

	        if (equipos.containsKey(equipo)) {
	            int victorias = equipos.get(equipo);
	            equipos.put(equipo, victorias + 1);
	            System.out.println("Victoria registrada. Total victorias de " + equipo + ": " + (victorias + 1));
	        } else {
	            System.out.println("El equipo no existe.");
	        }
	    }
	 
	 //Case3
	 public static void opcion3(Map<String, Integer> equipos) {
	        System.out.println("-- Victories actuales --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }

	        for (Map.Entry<String, Integer> e : equipos.entrySet()) {
	            System.out.println(e.getKey() + " : " + e.getValue() + " victorias");
	        }
	    }
	 
	 //Case4
	 public static void opcion4(Map<String, Integer> equipos) {
	        System.out.println("-- Equipo ganador --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }
	        
	        String ganador = "";
	        int max = -1;
	        for (Map.Entry<String, Integer> e : equipos.entrySet()) {
	            if (e.getValue() > max) {
	                max = e.getValue();
	                ganador = e.getKey();
	            }
	        }
	        
	        System.out.println("Equipo con más victorias: " + ganador + " (" + max + " victorias)");
	    }
	 
	 //case5
	 public static void opcion5(Map<String, Integer> equipos) throws IOException {
	        System.out.println("-- Comprobar si existe un equipo --");
	        System.out.print("Introduce el nombre del equipo: ");
	        String equipo = leerLinea();

	        if (equipos.containsKey(equipo))
	            System.out.println("El equipo existe en la lista.");
	        else
	            System.out.println("El equipo no existe.");
	    }
	 
	 //Case6
	 public static void opcion6(Map<String, Integer> equipos) throws IOException {
	        System.out.println("-- Eliminar equipo --");
	        System.out.print("Introduce el nombre del equipo a eliminar: ");
	        String equipo = leerLinea();

	        if (equipos.remove(equipo) != null)
	            System.out.println("Equipo eliminado correctamente.");
	        else
	            System.out.println("El equipo no existe.");
	    }
	 
	 //case7
	 public static void opcion7(Map<String, Integer> equipos) {
	        System.out.println("-- Total de partidas jugadas --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }

	        int total = 0;
	        for (int v : equipos.values()) {
	            total += v;
	        }
	        System.out.println("Total de victorias registradas: " + total);
	    }
	 
	 //Case8
	 public static void opcion8(Map<String, Integer> equipos) {
	        System.out.println("-- Porcentaje de victorias de cada equipo --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }
	        
	        int total = 0;
	        for (int v : equipos.values()) {
	            total += v;
	        }
	        
	        if (total == 0) {
	            System.out.println("No hay victorias registradas aún.");
	            return;
	        }
	        
	        for (Map.Entry<String, Integer> e : equipos.entrySet()) {
	            double porcentaje = ((double) e.getValue() * 100) / total;
	            System.out.println(e.getKey() + " : " + String.format("%.2f", porcentaje) + "%");
	        }
	    }
	 
	 //case9
	 public static void opcion9(Map<String, Integer> equipos) {
	        System.out.println("-- Comprobar si hay empate --");
	        if (equipos.isEmpty()) {
	            System.out.println("No hay equipos registrados.");
	            return;
	        }
	        
	        int max = -1;
	        int contadorMax = 0;
	        for (int v : equipos.values()) {
	            if (v > max) {
	                max = v;
	                contadorMax = 1;
	            } else if (v == max) {
	                contadorMax++;
	            }
	        }
	        
	        if (contadorMax > 1)
	            System.out.println("Hay empate entre " + contadorMax + " equipos con " + max + " victorias.");
	        else
	            System.out.println("No hay empate. El equipo con más victorias tiene " + max + " victorias.");
	    }
	}