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
		ArrayList<Double> nota = new ArrayList<>();
		
		boolean salir = false;
	    char opcion;
	    
		do {
            System.out.println("\n---Ejercicio 6---");
            System.out.println("A. Añadir calificacion");
            System.out.println("B. Eliminar una calificaci�n por posici�n");
            System.out.println("C. Mostrar todas las calificaciones");
            System.out.println("D. Calcular la media de las calificaciones");
            System.out.println("E. Mostrar cu�ntas calificaciones son aprobados (>=5)");
            System.out.println("F. Encontrar la calificaci�n m�s alta y m�s baja");
            System.out.println("G. Contar cu�ntas calificaciones hay por encima de la media");
            System.out.println("H. Modificar una calificaci�n");
            System.out.println("I. Salir");
            System.out.print("Selecciona una opci�n: ");
           
            opcion = leerLinea().toUpperCase().charAt(0);
            switch (opcion) {
                case 'A':opcionA(nota);break;
                case 'B':opcionB(nota);break;
                case 'C':opcionC(nota);break;
                case 'D':opcionD(nota);break;
                case 'E':opcionE(nota);break;
                case 'F':opcionF(nota);break;
                case 'G':opcionG(nota);break;
                case 'H':opcionH(nota);break;
                case 'I':salir = true;System.out.println("adios");break;
                default:System.err.println("Opcion no valida.");
            }
        } while (!salir);
	}
		
	//case1
	public static void opcionA(ArrayList<Double> nota) throws NumberFormatException, IOException{
			System.out.println("\n--Añadir una calificacion--");
			double calificacion;
			boolean salida = false;
			do {
				System.out.println("Añada una calificacion: ");
				calificacion = leerDoublePositivo();
				
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
	public static void opcionB(ArrayList<Double> nota) throws NumberFormatException, IOException{
			System.out.println("\n-- Eliminar calificación --");
			
			if (nota.isEmpty()) {
	            System.out.println("No hay calificaciones");
	            return;
			}
			
			opcionC(nota);
			int posicion;
			boolean valido = false;
			do {
				System.out.println("Introduce una posición: ");
				posicion = leerIntPositivo();
				
				if (posicion <= 0 || posicion > nota.size()) {
		            System.err.println("ERROR. La posición no es válida, inténtalo de nuevo.");
				} else {
		            valido = true;
				}
			} while (!valido);
				nota.remove(posicion - 1);
				System.out.println("Calificación eliminada correctamente");
	        }

	//case3
	public static void opcionC(ArrayList<Double> nota) {
		    System.out.println("\n-- Mostrar calificaciones --");

		    if (nota.isEmpty()) {
		        System.out.println("No hay calificaciones");
		        return;
		    }

		    for (int i = 0; i < nota.size(); i++) {
		        System.out.println("Calificación " + (i + 1) + ": " + nota.get(i));
		    }
		    /*int i = 1;
			for(double n : nota) {
    			System.out.println("Calificación " + i + ": " + n);
    			i++;
			}*/
		}
		
	//case4
	public static void opcionD(ArrayList<Double> nota) throws NumberFormatException, IOException {
		    System.out.println("\n-- Calcular media --");
		    
		    if (nota.isEmpty()) {
		        System.out.println("No hay calificaciones");
		        return;
		    }
		    
		    double suma = 0;
		    for (double n : nota) {
		        suma += n;
		    }
		    
		    double media = suma / nota.size();
		    System.out.println("La media de las calificaciones es: " + media);
		    }
		
	//case5
	public static void opcionE(ArrayList<Double> nota) throws NumberFormatException, IOException {
		System.out.println("\n-- Contar aprobados --");
		
		if (nota.isEmpty()) {
	        System.out.println("No hay calificaciones");
	        return;
	    }
		
		int aprobados = 0;
	    for (double n : nota) {
	        if (n >= 5) {
	            aprobados++;
	        }
	    }
	    
	    System.out.println("Número de calificaciones aprobadas: " + aprobados);
	}
	
	//case6
	public static void opcionF(ArrayList<Double> nota) {
		System.out.println("\n-- Calificación más alta y más baja --");
		
		 if (nota.isEmpty()) {
		        System.out.println("No hay calificaciones");
		        return;
		    }
		 
		 double max = nota.get(0);
		 double min = nota.get(0);
		 for (double n : nota) {
			 if (n > max) {
				 max = n;
				}
			 if (n < min) {
				 min = n;
		        }
		    }
		 System.out.println("La calificación más alta es: " + max);
		 System.out.println("La calificación más baja es: " + min);
	}
	
	//Case7
	public static void opcionG(ArrayList<Double> nota) {
		System.out.println("\n-- Contar calificaciones por encima de la media --");
		
		if (nota.isEmpty()) {
	        System.out.println("No hay calificaciones");
	        return;
	    }
		
		double suma = 0;
	    for (double n : nota) {
	        suma += n;
	    }
	    double media = suma / nota.size();
	    
	    int contador = 0;
	    for (double n : nota) {
	        if (n > media) {
	            contador++;
	        }
	    }
	    System.out.println("Número de calificaciones por encima de la media: " + contador);
	}
	
	//case8
	public static void opcionH(ArrayList<Double> nota) throws IOException {
		System.out.println("-- Modificar una calificación --");
		
		if (nota.isEmpty()) {
	        System.out.println("No hay calificaciones");
	        return;
	    }
		
		opcionC(nota);
		int posicion;
		do {
			System.out.println("Introduce la posición de la calificación a modificar: ");
			posicion = leerIntPositivo();
	    } while (posicion <= 0 || posicion > nota.size());
		
		double nuevaNota;
	    do {
	        System.out.println("Introduce la nueva calificación (0-10): ");
	        nuevaNota = leerDoublePositivo();
	        if (nuevaNota > 10) {
	            System.err.println("ERROR. La calificación no puede ser mayor que 10");
	        }
	    } while (nuevaNota > 10);
	    
	    nota.set(posicion - 1, nuevaNota);
	    System.out.println("Calificación modificada correctamente");
	}
}