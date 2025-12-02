package EjerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio41 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int opcion;
		boolean salir = false;
		String[] alumnos= new String[6];
		String[] asignaturas = new String[5];
		double [][] notas = new double[6][5];
		
		do {
			System.out.println("   SISTEMA DE GESTIÓN DE ALUMNOS Y NOTAS");
            System.out.println("1.  Introducir nombres de alumnos y asignaturas");
            System.out.println("2.  Introducir todas las notas");
            System.out.println("3.  Mostrar tabla completa");
            System.out.println("4.  Calcular y mostrar media de cada alumno");
            System.out.println("5.  Buscar alumno por nombre");
            System.out.println("6.  Mostrar asignatura con menor media");
            System.out.println("7.  Contar alumnos con todas aprobadas");
            System.out.println("8.  Mostrar alumnos suspendidos en asignatura");
            System.out.println("9.  Modificar nota");
            System.out.println("10. Salir");
            
            opcion = leerEntero("Selecciona una opción: ");
            
            switch(opcion) {
            case 1:introducirNombres(alumnos, asignaturas); break;
            case 2:introducirNotas(alumnos, asignaturas, notas);break;
			//case 3:
			//case 4:
			//case 5:
			//case 6:
			//case 7:
			//case 8:
			//case 9:
			case 10:salir = true;System.out.println("Saliendo de la aplicación");break;
			default: System.err.println("Opción no válida");
			}
	}while(!salir);
}
	
	public static void introducirNombres(String[] alumnos, String[] asignaturas)throws NumberFormatException, IOException  {
		 System.out.println("\n--- Nombres de Alumnos ---");
	        for (int i = 0; i < alumnos.length; i++) {
	            String nombre;
	            do {
	                nombre = leerString("Alumno " + (i + 1) + ": ");
	                if (nombre.trim().isEmpty()) {
	                    System.err.println("El nombre del alumno no puede estar vacío.");
	                }
	            } while (nombre.trim().isEmpty());
	            alumnos[i] = nombre;
	        }

	        System.out.println("\n--- Nombres de Asignaturas ---");
	        for (int i = 0; i < asignaturas.length; i++) {
	            String asignatura;
	            do {
	                asignatura = leerString("Asignatura " + (i + 1) + ": ");
	                if (asignatura.isEmpty()) {
	                    System.out.println("El nombre de a asignatura no puede estar vacío.");
	                }
	            } while (asignatura.isEmpty());
	            asignaturas[i] = asignatura;
	        }

	    }
	public static void introducirNotas(String[] alumnos, String[] asignaturas, double [][] notas)
			throws NumberFormatException, IOException{
		
		
	}

	// Metodos auxiliares
	public static int leerEntero(String mensaje) throws IOException {
	    int numero = -1;
	    boolean valido = false;
	    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
	    while (!valido) {
	        try {
	            System.out.print(mensaje);
	            numero = Integer.parseInt(leer.readLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.out.println("Debes introducir un número entero.");
	        }
	    }
	
	    return numero;
	}

	public static String leerString(String mensaje) throws IOException {
	    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println(mensaje);
	    return leer.readLine();
	}
	
	public static double leerNota(String mensaje) throws IOException {
	    double nota = -1;
	    boolean valida = false;
	    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
	    while (!valida) {
	        try {
	            System.out.print(mensaje);
	            nota = Double.parseDouble(leer.readLine());
	
	            if (nota >= 0 && nota <= 10) {
	                valida = true;
	            } else {
	                System.out.println("Error: La nota debe estar entre 0 y 10.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error: Debes introducir un número válido.");
	        }
	    }
	
	    return nota;
	}
	
	}