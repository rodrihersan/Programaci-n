package ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<estudiante> estudiantes = new ArrayList<estudiante>();

		boolean salir = false;

		do {
			System.out.println("== GESTION ALUMNOS DAW==");
			System.out.println("1.Registrar estudiante");
			System.out.println("2.Mostrar todos");
			System.out.println("3. Buscar por ID");
			System.out.println("4. Mostrar aprobados");
			System.out.println("5. Filtrar por clasificación");
			System.out.println("6. Alumnos que pasan de curso");
			System.out.println("7. Salir");
			System.out.println("Introduce una opcion: ");
			int opcion = Integer.parseInt(leer.readLine());

			switch (opcion) {
			case 1:
				registrarEstudiantes(estudiantes);
				break;
			case 2:
				mostrarDatos(estudiantes);
				break;
			case 3:
				buscarPorId(estudiantes);
				break;
			case 4:
				mostrarAprobados(estudiantes);
				break;
			case 5:
				buscarPorCategoria(estudiantes);
				break;
			case 6:
				mostrarAlumnosQuePasen(estudiantes);
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

	private static void registrarEstudiantes(ArrayList<estudiante> estudiantes) throws IOException {
		boolean parar = false;
		System.out.println("--Registrar estudiantes--");

		while (parar == false) {
			System.out.println("Introduce los datos del estudiante " + (estudiantes.size() + 1));
			estudiantes.add(new estudiante());
			estudiantes.getLast().pedirDatos(estudiantes.size());

			System.out.println("¿Desea introducir otro estudiante? (S/N)");
			char opcion = leer.readLine().toUpperCase().charAt(0);
			if (opcion == 'N')
				parar = true;
		}

	}

	private static void mostrarDatos(ArrayList<estudiante> estudiantes) {
		System.out.println("--Listado estudiantes--");
		for (estudiante e : estudiantes) {
			e.mostrarDatos();
		}
	}

	private static void buscarPorId(ArrayList<estudiante> estudiantes) {
		System.out.println("--Buscar Por Id--");

		int id = -1;
		boolean todoOk = false;
		boolean enc = false;

		do {
			try {
				System.out.print("Introduce el id del estudiante: ");
				id = Integer.parseInt(leer.readLine());
				todoOk = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} while (todoOk != true);

		for (int i = 0; i < estudiantes.size() && !enc; i++) {
			if (estudiantes.get(i).getId() == id) {
				estudiantes.get(i).mostrarDatos();
				enc = true;
			}
		}

		if (enc == false) {
			System.out.println("No se ha encontrado el estudiante con ese ID");
		}
	}

	private static void mostrarAprobados(ArrayList<estudiante> estudiantes) {
		System.out.println("-- Estudiantes aprobados --");
		for (estudiante e : estudiantes) {
			if (e.notaMediaAprobada()) {
				System.out.println(e.getNombre());
			}
		}

	}

	private static void buscarPorCategoria(ArrayList<estudiante> estudiantes) {
		System.out.println("-- Buscar por categoria --");
		boolean todoOk = false;
		String categoria = "";
		boolean enc = false;

		do {

			try {
				System.out.print("Introduce la categoria a buscar (Sobresaliente-Notable-Bien-Suficiente-Insuficiente): ");
				categoria = leer.readLine();
				if (categoria.equalsIgnoreCase("Sobresaliente") || categoria.equalsIgnoreCase("Notable")
						|| categoria.equalsIgnoreCase("Bien") || categoria.equalsIgnoreCase("Suficiente")
						|| categoria.equalsIgnoreCase("Insuficiente")) {
					todoOk = true;
				} else {
					System.out.println(
							"Tienes que introducir una categoria correcta (Sobresaliente-Notable-Bien-Suficiente-Insuficiente)");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (todoOk == false);
		
		for (int i = 0; i < estudiantes.size() ; i++) {
			if (estudiantes.get(i).notaEscrita().equalsIgnoreCase(categoria)) {
				System.out.println(estudiantes.get(i).getNombre());
				enc = true;
			}
		}

		if (enc == false) {
			System.out.println("No se ha encontrado el estudiantes con esa categoria");
		}

	}
	
	private static void mostrarAlumnosQuePasen(ArrayList<estudiante> estudiantes) {
		System.out.println("-- Estudiantes que pasan de curso o titulan --");
		for (estudiante e : estudiantes) {
			if (e.notaMediaAprobada()) {
				if(e.getCurso() == 1)
					System.out.println(e.getNombre() + " pasa de curso a 2º de DAW");
				else
					System.out.println(e.getNombre() + " obtiene el titulo de DAW");
			}
		}
		
	}
}