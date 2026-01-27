package ejercicio14;

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
			System.out.println("1.Registrar estudiante");
			System.out.println("2.Añadir nota");
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
					opcion = Integer.parseInt(LEER.readLine());
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				datosOK = true;
			}


			switch (opcion) {
			case 1:
				registrarEstudiante(alumnos);
				break;
			case 2:
				añadirNota(alumnos);
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:
				System.out.println("Saliendo...");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
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
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			datosOK = true;
		}
		
		boolean enc = false;
		for(Alumno alumno: alumnos) {
			if(alumno.getId() == idABuscar) {
				alumno.añadirNota();
				enc = true;
			}
		}
		if(!enc)
			System.out.println("No se ha encontrado el alumno");
		
	}

}