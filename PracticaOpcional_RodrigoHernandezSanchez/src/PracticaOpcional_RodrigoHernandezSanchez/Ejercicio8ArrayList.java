package PracticaOpcional_RodrigoHernandezSanchez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.io.InputStreamReader;
import java.io.InputStreamReader;

public class Ejercicio8ArrayList {
	
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
		ArrayList<Integer> nota = new ArrayList<>();
		
		boolean salir = false;
	    char opcion;
	    
		do {
            System.out.println("\n---Ejercicio 6---");
            System.out.println("A. Añadir calificación");
            System.out.println("B. Eliminar una calificación por posición");
            System.out.println("C. Mostrar todas las calificaciones");
            System.out.println("D. Calcular la media de las calificaciones");
            System.out.println("E. Mostrar cuántas calificaciones son aprobados (>=5)");
            System.out.println("F. Encontrar la calificación más alta y más baja");
            System.out.println("G. Contar cuántas calificaciones hay por encima de la media");
            System.out.println("H. Modificar una calificación");
            System.out.println("I. Salir");
            System.out.print("Selecciona una opción: ");
           
            opcion = leerLinea().toUpperCase().charAt(0);
            switch (opcion) {
                case 'A':opcionA(nota);break;
                case 'B':opcionB(nota);break;
                //case 'C':opcionC(nota);break;
                //case 'D':opcionD(nota);break;
                //case 'E':opcionE(nota);break;
                //case 'F':opcionF(nota);break;
                //case 'G':opcionG(nota);break;
                //case 'H':opcionG(nota);break;
                case 'I':salir = true;System.out.println("adios");break;
                default:System.err.println("Opción no válida.");
            }
        } while (!salir);
	}
		
		//case1
		public static void opcionA(ArrayList<Integer> nota) throws NumberFormatException, IOException{
			System.out.println("\n--Añadir tarea--");
			System.out.println("Añadir una calificacion: ");
			int calificacion = leerIntPositivo();
			boolean salida = false;
			do {
			if(calificacion > 10) {
				System.err.println("No puede ser mayor de 10");
			}else {
			nota.add(calificacion);
			System.out.println("Nota registrada correctamente");
			salida = true;
			}
			}while(!salida);
		}
		
		//case2
		public static void opcionB(ArrayList<Integer> nota) throws NumberFormatException, IOException{
			
		}
	}

