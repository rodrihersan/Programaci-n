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
			System.out.println("--- SISTEMA DE GESTIÓN DE ALUMNOS Y NOTAS ---");
			System.out.println("==============================================");
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
			case 3: mostrarTablaCompleta(alumnos, asignaturas, notas);break;
			case 4:calcularMediaAlumnos(alumnos, notas);break;
			case 5:buscarAlumno(alumnos, asignaturas, notas);break;
			case 6:mostrarAsignaturaConMenorMedia(asignaturas,notas);break;
			case 7:contarAlumnosAprobados(notas);break;
			case 8:mostrarSuspensosDeAsignatura(alumnos,asignaturas,notas);break;
			case 9:modificarNota(alumnos,asignaturas,notas);break;
			case 10:salir = true;System.out.println("Saliendo de la aplicación");break;
			default: System.err.println("Opción no válida");
			}
	}while(!salir);
}

//case1	
	public static void introducirNombres(String[] alumnos, String[] asignaturas)
			throws NumberFormatException, IOException  {
		
		 System.out.println("--- Nombres de Alumnos ---");
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

	        System.out.println("--- Nombres de Asignaturas ---");
	        for (int i = 0; i < asignaturas.length; i++) {
	            String asignatura;
	            do {
	                asignatura = leerString("Asignatura " + (i + 1) + ": ");
	                if (asignatura.trim().isEmpty()) {
	                    System.err.println("El nombre de la asignatura no puede estar vacío.");
	                }
	            } while (asignatura.trim().isEmpty());
	            asignaturas[i] = asignatura;
	        }

	    }
	
//case2	
	public static void introducirNotas(String[] alumnos, String[] asignaturas, double [][] notas)
			throws NumberFormatException, IOException{
			
		System.out.println("--- INTRODUCIR NOTAS ---");
			
			for (int i = 0; i < notas.length; i++) {
				System.out.println("--- Notas de " + alumnos[i] + " ---");
				for (int j = 0; j < notas[i].length; j++) {
					notas[i][j] = leerNota("Introduce la nota de " + asignaturas[j] + ": ");
		}
		System.out.println();
		}
		System.out.println("Todas las notas han sido introducidas.");
	}
	
//case3
	public static void mostrarTablaCompleta(String[] alumnos, String[] asignaturas, double[][] notas)
			throws NumberFormatException,IOException {
		System.out.println("--- TABLA COMPLETA ---");
		System.out.print("\t\t");
		for (int i = 0; i < asignaturas.length; i++) {
			System.out.print(asignaturas[i] + "\t\t");
			}
		
		System.out.println();
		for (int i = 0; i < notas.length; i++) {
			System.out.print(alumnos[i] + "\t\t");
			for (int j = 0; j < notas[i].length; j++) {
				System.out.print(notas[i][j] + "\t\t");
				}
			System.out.println();
		}
	}
	
//case4	
	public static void calcularMediaAlumnos(String[] alumnos, double[][]notas) 
			throws NumberFormatException,IOException{
		
		System.out.println("--- MEDIA DE CADA ALUMNO ---");
		for (int i = 0; i < notas.length; i++) {
			double media = 0;
			for (int j = 0; j < notas[i].length; j++) {
				media += notas[i][j];
			}
			
			media /= notas[i].length;
			System.out.println(alumnos[i] + ": " + media);
			}
		}
	
//case5
	public static void buscarAlumno(String[] alumnos, String[] asignaturas,double[][] notas) 
			throws NumberFormatException,IOException {
		
		System.out.println("--- BUSCAR ALUMNO ---");
		String nombre = leerString("Introduce el nombre del alumno: ");
		boolean encontrado = false;
		
		for (int i = 0; i < alumnos.length && !encontrado; i++) {
			if (alumnos[i].equalsIgnoreCase(nombre)) {
				System.out.println("--- NOTAS DE " + alumnos[i] + " ---");
				for (int j = 0; j < asignaturas.length; j++) {
					System.out.println(asignaturas[j] + ": " + notas[i][j]);
					}
				encontrado = true;
				}
			}
		if (!encontrado) {
			System.out.println("Alumno no encontrado.");
			}
		}
	
//case6
	public static void mostrarAsignaturaConMenorMedia(String[] asignaturas,double[][] notas) 
			throws NumberFormatException,IOException{
		System.out.println("--- ASIGNATURA CON MENOR MEDIA ---");
		double menorMedia = -1;
		int posicion = -1;
		
		for (int i = 0; i < notas[0].length; i++) {
			double media = 0;
			for (int j = 0; j < notas.length; j++) {
			media += notas[j][i];
			}
		media /= notas.length;
		if (media < menorMedia) {
		menorMedia = media;
		posicion = i;
		}
	}
		System.out.println(asignaturas[posicion] + ": " + menorMedia);
	}

//Opcion7	
	public static void contarAlumnosAprobados(double[][] notas) throws NumberFormatException,IOException{
		
		System.out.println("\n--- CONTAR ALUMNOS APROBADOS ---\n");
		int contador = 0;
		for (int i = 0; i < notas.length; i++) {
			boolean aprobado = true;
			for (int j = 0; j < notas[i].length && aprobado; j++) {
				if (notas[i][j] < 5) {
					aprobado = false;
					}
				}
			if (aprobado) {
				contador++;
				}
			}
		System.out.println("Número de alumnos aprobados: " + contador);
		}

//opcion8	
	public static void mostrarSuspensosDeAsignatura(String[] alumnos, String[] asignaturas, double[][] notas) 
			throws NumberFormatException,IOException{
		
		String asignatura = leerString("Introduce la asignatura: ").trim();
		int pos = -1;
		
	    for (int i = 0; i < asignaturas.length; i++) {
	        if (asignaturas[i].trim().equalsIgnoreCase(asignatura)) {
	            pos = i;
	            break;
	        }
	    }
	    if (pos == -1) {
	        System.out.println("La asignatura no existe.");
	        return;
	    }
	    
	    System.out.println("Alumnos que han suspendido " + asignaturas[pos] + ":");
	    boolean haySuspensos = false;

	    for (int i = 0; i < alumnos.length; i++) {
	        if (notas[i][pos] < 5) {
	            System.out.println("- " + alumnos[i] + " (nota: " + notas[i][pos] + ")");
	            haySuspensos = true;
	        }
	    }
	    if (!haySuspensos) {
	        System.out.println("Ningún alumno ha suspendido esta asignatura.");
	    }
	}

//opcion9
	public static void modificarNota(String[] alumnos, String[] asignaturas, double[][] notas) 
			throws NumberFormatException,IOException {

	    System.out.println("--- MODIFICAR NOTA DE UN ALUMNO ---");

	    // Pedir nombre del alumno
	    String alumno = leerString("Introduce el nombre del alumno: ").trim();

	    int posAlumno = -1;

	    // Buscar alumno
	    for (int i = 0; i < alumnos.length; i++) {
	        if (alumnos[i].trim().equalsIgnoreCase(alumno)) {
	            posAlumno = i;
	            break;
	        }
	    }

	    if (posAlumno == -1) {
	        System.out.println("El alumno no existe.");
	        return;
	    }

	    // Pedir nombre de la asignatura
	    String asignatura = leerString("Introduce la asignatura: ").trim();

	    int posAsignatura = -1;

	    // Buscar la asignatura
	    for (int i = 0; i < asignaturas.length; i++) {
	        if (asignaturas[i].trim().equalsIgnoreCase(asignatura)) {
	            posAsignatura = i;
	            break;
	        }
	    }

	    if (posAsignatura == -1) {
	        System.out.println("La asignatura no existe.");
	        return;
	    }

	    // Pedir nueva nota validada
	    double nuevaNota;
	    do {
	        nuevaNota = leerDouble("Introduce la nueva nota (0-10): ");
	        if (nuevaNota < 0 || nuevaNota > 10) {
	            System.out.println("La nota debe estar entre 0 y 10.");
	        }
	    } while (nuevaNota < 0 || nuevaNota > 10);

	    // Modificar nota
	    notas[posAlumno][posAsignatura] = nuevaNota;

	    System.out.println("Nota modificada correctamente.");
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
	            System.err.println("Debes introducir un número entero.");
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
	                System.err.println("Error: La nota debe estar entre 0 y 10.");
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Error: Debes introducir un número válido.");
	        }
	    }
	
	    return nota;
	}
	
	public static double leerDouble(String mensaje) throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double numero =0;
		boolean valido=false;
		
		while(!valido) {
			try {
				System.out.print(mensaje);
				numero = Double.parseDouble(leer.readLine());
	            valido = true;
	        } catch (NumberFormatException e) {
	            System.err.print("ERROR. ");
	            System.out.println("Introduce un número válido");
	        }
	    }
	    return numero;
		}
	}