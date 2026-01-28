package ejercicio14ConArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		boolean salir = false;

		do {
			System.out.println("== GESTION ALUMNOS DAW==");
			System.out.println("1. Registrar estudiante");
			System.out.println("2. Añadir nota");
			System.out.println("3. Ver calificaciones");
			System.out.println("4. Calcular media");
			System.out.println("5. Estudiante brillante");
			System.out.println("6. Alerta de suspensos");
			System.out.println("7. Salir");
			System.out.println("Introduce una opcion: ");
			
			int opcion = -1;
			boolean datosOK = false;	
			while (!datosOK) {
				try {
					String entrada = LEER.readLine();
					opcion = Integer.parseInt(entrada);
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.out.println("Por favor, introduce un número entero.");
				}
			}

			switch (opcion) {
				case 1: registrarEstudiante(alumnos); break;
				case 2: añadirNota(alumnos); break;
				case 3: verCalificaciones(alumnos); break;
				case 4: calcularMedia(alumnos); break;
				case 5: alumnoBrillante(alumnos); break;
				case 6: alertaSuspensos(alumnos); break;
				case 7: System.out.println("Saliendo"); salir = true; break;
				default: System.out.println("Opcion no valida");
			}

		} while (!salir);
	}

	private static void registrarEstudiante(ArrayList<Alumno> alumnos) {
		Alumno a = new Alumno();
		a.pedirDatos(alumnos);
		alumnos.add(a);
	}
	
	private static void añadirNota(ArrayList<Alumno> alumnos) {
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante a añadir una nota: ");
				idABuscar = Integer.parseInt(LEER.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.out.println("ID no válido.");
			}
		}
		
		boolean enc = false;
		for(Alumno alumno : alumnos) {
			if(alumno.getId() == idABuscar) {
				alumno.añadirNota();
				enc = true;
			}
		}
		if(!enc) System.out.println("No se ha encontrado el alumno");
	}
	
	private static void verCalificaciones(ArrayList<Alumno> alumnos) {
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante para ver notas: ");
				idABuscar = Integer.parseInt(LEER.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.out.println("ID no válido.");
			}
		}
		
		boolean enc = false;
		for(Alumno alumno : alumnos) {
			if(alumno.getId() == idABuscar) {
				alumno.verCalificaciones();
				enc = true;
			}
		}
		if(!enc) System.out.println("No se ha encontrado el alumno");
	}
	
	private static void calcularMedia(ArrayList<Alumno> alumnos) {
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante para calcular media: ");
				idABuscar = Integer.parseInt(LEER.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.out.println("ID no válido.");
			}
		}
		
		boolean enc = false;
		for(Alumno alumno : alumnos) {
			if(alumno.getId() == idABuscar) {
				alumno.mostrarMedia();
				enc = true;
			}
		}
		if(!enc) System.out.println("No se ha encontrado el alumno");
	}
	
	private static void alumnoBrillante(ArrayList<Alumno> alumnos) {
		if (alumnos.isEmpty()) {
			System.out.println("No hay alumnos registrados.");
			return;
		}
		double notaMediaMaxima = -1;
		Alumno alumnoBrillante = null;
		for(Alumno alumno : alumnos) {
			double mediaActual = alumno.devolverMedia();
			if(mediaActual > notaMediaMaxima) {
				notaMediaMaxima = mediaActual;
				alumnoBrillante = alumno;
			}
		}
		
		if (alumnoBrillante != null) {
			System.out.println("El alumno brillante es: " + alumnoBrillante.toString());
		}
	}
	
	private static void alertaSuspensos(ArrayList<Alumno> alumnos) {
	    System.out.println("--- ALUMNOS CON SUSPENSOS ---");
	    for (Alumno alumno : alumnos) {
	        // Usamos el método que acabamos de crear
	        int totalSuspensos = alumno.contarSuspensos();
	        
	        // Si tiene 1 o más, lanzamos la alerta
	        if (totalSuspensos > 0) {
	            System.out.println("Alumno: " + alumno.getNombre() + 
	                               " | ID: " + alumno.getId() + 
	                               " | Total suspensos: " + totalSuspensos);
	        }
	    }
	}
}