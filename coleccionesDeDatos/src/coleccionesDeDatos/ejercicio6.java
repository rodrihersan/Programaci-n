package coleccionesDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio6 {
	
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
	public static double leerDouble() throws IOException{
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
	public static double leerDoublePositivo() throws IOException {
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

	public static void main(String[] args) throws NumberFormatException, IOException{
		ArrayList<String> tareas = new ArrayList<>();
		
		boolean salir = false;
	    char opcion;
	    
		do {
            System.out.println("\n---Ejercicio 6---");
            System.out.println("A. Añadir tarea al final de la lista");
            System.out.println("B. Insertar tarea en una posición específica");
            System.out.println("C. Mostrar todas las tareas (numeradas)");
            System.out.println("D. Marcar tarea como completada (eliminarla de la lista)");
            System.out.println("E. Mostrar número total de tareas pendientes");
            System.out.println("F. Buscar si existe una tarea específica");
            System.out.println("G. Eliminar todas las tareas");
            System.out.println("H. Salir");
            System.out.print("Selecciona una opción: ");
           
            opcion = leerLinea().toUpperCase().charAt(0);
            switch (opcion) {
                case 'A':opcionA(tareas);break;
                case 'B':opcionB(tareas);break;
                case 'C':opcionC(tareas);break;
                case 'D':opcionD(tareas);break;
                case 'E':opcionE(tareas);break;
                case 'F':opcionF(tareas);break;
                case 'G':opcionG(tareas);break;
                case 'H':salir = true;System.out.println("adios");break;
                default:System.err.println("Opción no válida.");
            }
        } while (!salir);
	}

//case1
	public static void opcionA(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Añadir tarea--");
		System.out.println("Añadir una tarea a la lista");
		String tarea = leerLinea();
		tareas.add(tarea);
	}

	//case2
	public static void opcionB(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Añadir tarea a una posición--");
		System.out.println("Introduce una posicion: ");
		int posicion = leerIntPositivo();
		
		System.out.println("Añadir una tarea a la lista");
		String tarea = leerLinea();
		tareas.add(posicion, tarea);
	}
	
	//case3
	public static void opcionC(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Mostras tareas--");
		
		for(int i =0; i<tareas.size(); i++) {
			System.out.println((i+1)+" "+tareas.get(i));
		}
	}
	
	//case4
	public static void opcionD(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Completar tareas--");
		
		opcionC(tareas);
		int posicion;
		do {
			System.out.println("Introduce una posicion: ");
			posicion = leerIntPositivo();
		}while(posicion<0 && posicion> tareas.size());
		tareas.remove(posicion-1);
	}
	
	//case5
	public static void opcionE(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Nº tareas pendientes--");
		
		System.out.println("-Qeudan "+tareas.size()+ " taras pendientes.");	
	}
	
	//case6
	public static void opcionF(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Buscar si existe una tarea--");
		
		System.out.println("Introduce tarea a buscar: ");
		String	tareaBuscar = leerLinea();
		
		if(tareas.contains(tareaBuscar)) {
			System.out.println("Tarea encontrada");
		}else {
			System.out.println("Tarea no encontrada");
		}
	}
	
	//case7
	public static void opcionG(ArrayList<String> tareas) throws NumberFormatException, IOException{
		System.out.println("--Eliminar tarea--");
		tareas.clear();
	}
}