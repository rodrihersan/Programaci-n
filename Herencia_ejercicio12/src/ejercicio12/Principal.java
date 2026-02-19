package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

		boolean salir = false;
		do {
			System.out.println("\n=== COLEGIO CALASANZ SALAMANCA ===");
			System.out.println("1. Registrar Estudiante");
			System.out.println("2. Gestionar Calificaciones");
			System.out.println("3. Consultar Media Académica");
			System.out.println("4. Listar Estudiantes Aprobados");
			System.out.println("5. Premio a la Excelencia");
			System.out.println("6. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== Registrar Estudiante ===");
				registrarEstudiante(estudiantes);
				break;
			case 2:
				System.out.println("=== Gestionar Calificaciones ===");
				gestionarCalificaciones(estudiantes);
				break;
			case 3:
				System.out.println("=== Consultar Media Académica ===");
				consultarMedia(estudiantes);
				break;
			case 4:
				System.out.println("=== Listar Estudiantes Aprobados ===");
				listarAprobados(estudiantes);
				break;
			case 5:
				System.out.println("=== Premio a la Excelencia ===");
				premioExcelencia(estudiantes);
				break;
			case 6:
				salir = true;
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void registrarEstudiante(ArrayList<Estudiante> estudiantes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoEstudiante = "";
		do {
			try {
				System.out.print("Introduce el tipo de estudiante (FP o Secundaria): ");
				tipoEstudiante = leer.readLine();

				if (!tipoEstudiante.equalsIgnoreCase("fp") && !tipoEstudiante.equalsIgnoreCase("secundaria")) {
					System.out.println("El tipo de estudiante no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoEstudiante.equalsIgnoreCase("fp") && !tipoEstudiante.equalsIgnoreCase("secundaria"));

		int id = 1;
		if (estudiantes.size() > 0)
			id = estudiantes.getLast().getId() + 1;

		if (tipoEstudiante.equalsIgnoreCase("fp")) {
			EstudianteFP estudianteFP = new EstudianteFP();
			estudianteFP.pedirDatos(id);
			estudiantes.add(estudianteFP);
		} else {
			EstudianteSecundaria estudianteSecundaria = new EstudianteSecundaria();
			estudianteSecundaria.pedirDatos(id);
			estudiantes.add(estudianteSecundaria);
		}

		System.out.println("Estudiante registrado correctamente con ID: " + id);
	}

	private static Estudiante buscarEstudiantePorId(ArrayList<Estudiante> estudiantes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idEstudiante = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el ID del estudiante: ");
				idEstudiante = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getId() == idEstudiante) {
				return estudiante;
			}
		}

		System.out.println("No se ha encontrado el estudiante");
		return null;
	}

	private static void gestionarCalificaciones(ArrayList<Estudiante> estudiantes) {
		Estudiante estudiante = buscarEstudiantePorId(estudiantes);

		if (estudiante != null) {
			if (estudiante instanceof EstudianteFP) {
				if (((EstudianteFP) estudiante).añadirNota() == true) {
					System.out.println("Nota añadida correctamente");
				} else {
					System.out.println("No se pueden añadir más notas, límite de 8 asignaturas alcanzado");
				}
			} else if (estudiante instanceof EstudianteSecundaria) {
				((EstudianteSecundaria) estudiante).registrarEvaluacion();
				System.out.println("Evaluación registrada correctamente");
			}
		}
	}

	private static void consultarMedia(ArrayList<Estudiante> estudiantes) {
		Estudiante estudiante = buscarEstudiantePorId(estudiantes);

		if (estudiante != null) {
			System.out.printf("La media académica del estudiante es: %.2f%n", estudiante.calcularMedia());
		}
	}

	private static void listarAprobados(ArrayList<Estudiante> estudiantes) {
		boolean enc = false;
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.calcularMedia() >= 5) {
				if (estudiante instanceof EstudianteFP) {
					((EstudianteFP) estudiante).mostrarDatos();
				} else {
					((EstudianteSecundaria) estudiante).mostrarDatos();
				}
				enc = true;
			}
		}

		if (!enc)
			System.out.println("No hay estudiantes aprobados");
	}

	private static void premioExcelencia(ArrayList<Estudiante> estudiantes) {
		if (estudiantes.size() == 0) {
			System.out.println("No hay estudiantes registrados");
			return;
		}

		Estudiante mejor = estudiantes.get(0);
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.calcularMedia() > mejor.calcularMedia()) {
				mejor = estudiante;
			}
		}

		System.out.println("=== Estudiante con la nota media más alta ===");
		if (mejor instanceof EstudianteFP) {
			((EstudianteFP) mejor).mostrarDatos();
		} else {
			((EstudianteSecundaria) mejor).mostrarDatos();
		}
	}

}