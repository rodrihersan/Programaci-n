package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		boolean salir = false;
		do {
			System.out.println("\n=== HOSPITAL CALASANZ ===");
			System.out.println("1. Registrar Paciente ");
			System.out.println("2. Añadir tratamiento a paciente urgencias");
			System.out.println("3. Añadir consulta a paciente cita previa");
			System.out.println("4. Mostrar Historial de un Paciente");
			System.out.println("5. Filtrar Urgencias por Gravedad");
			System.out.println("6. salir");
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
				System.out.println("===  Registrar Paciente ===");
				registrarPaciente(pacientes);
				break;
			case 2:
				System.out.println("=== Añadir tratamiento a paciente urgencias ===");
				añadirTratamiento(pacientes);
				break;
			case 3:
				System.out.println("=== Añadir consulta a paciente cita previa ===");
				añadirFechaConsulta(pacientes);
				break;
			case 4:
				System.out.println("=== Mostrar Historial de un Paciente ===");
				mostrarHistorial(pacientes);
				break;
			case 5:
				System.out.println("===  Filtrar Urgencias por Gravedad ===");
				filtarGravedad(pacientes);
				break;
			case 6:
				System.out.println("=== Mostrar los datos ===");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);

	}

	private static void registrarPaciente(ArrayList<Paciente> pacientes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoPaciente = "";
		do {
			try {
				System.out.print("Introduce si el paciente es de Urgencias o de Cita");
				tipoPaciente = leer.readLine();

				if (!tipoPaciente.equalsIgnoreCase("urgencias") && !tipoPaciente.equalsIgnoreCase("cita")) {
					System.out.println("El tipo de paciente no es correcto");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoPaciente.equalsIgnoreCase("urgencias") && !tipoPaciente.equalsIgnoreCase("cita"));

		int id = 1;
		if (pacientes.size() > 0)
			id = pacientes.getLast().getId() + 1;
		if (tipoPaciente.equalsIgnoreCase("urgencias")) {
			PacienteUrgencias pacienteUrg = new PacienteUrgencias();
			pacienteUrg.pedirDatos(id);
			pacientes.add(pacienteUrg);
		} else {
			PacienteCitaPrevia pacienteCita = new PacienteCitaPrevia();
			pacienteCita.pedirDatos(id);
			pacientes.add(pacienteCita);
		}

	}

	private static Paciente buscarPacientePorId(ArrayList<Paciente> pacientes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idPaciente = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del paciente a buscar: ");
				idPaciente = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		for (Paciente paciente : pacientes) {
			if (paciente.getId() == idPaciente) {
				return paciente;
			}
		}

		System.out.println("No se ha encontrado el paciente");
		return null;

	}

	private static void añadirTratamiento(ArrayList<Paciente> pacientes) {
		Paciente paciente = buscarPacientePorId(pacientes);

		if (paciente != null) {
			if (paciente instanceof PacienteUrgencias) {
				if (((PacienteUrgencias) paciente).añadirTratamiento() == true) {
					System.out.println("Tratamiento añadido correctamente");
				} else
					System.out.println("No se pueden añadir mas tratamientos");
			} else {
				System.out.println("Paciente incorrecto");
			}

		}

	}

	private static void añadirFechaConsulta(ArrayList<Paciente> pacientes) {
		Paciente paciente = buscarPacientePorId(pacientes);

		if (paciente != null) {
			if (paciente instanceof PacienteCitaPrevia) {
				if (((PacienteCitaPrevia) paciente).añadirCita() == true) {
					System.out.println("Cita fecha añadida correctamente");
				} else
					System.out.println("No se pueden añadir mas fechas");
			} else {
				System.out.println("Paciente incorrecto");
			}

		}

	}

	private static void mostrarHistorial(ArrayList<Paciente> pacientes) {
		Paciente paciente = buscarPacientePorId(pacientes);
		if (paciente != null) {
			if (paciente instanceof PacienteCitaPrevia) {
				((PacienteCitaPrevia) paciente).mostrarDatos();
			} else {
				((PacienteUrgencias) paciente).mostrarDatos();
			}
		}

	}

	private static void filtarGravedad(ArrayList<Paciente> pacientes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int gravedad = 0;
		while (!datosOK) {
			try {
				do {
					System.out.print("Introduce la gravedad (1-5): ");
					gravedad = Integer.parseInt(leer.readLine());
					if (gravedad < 1 || gravedad > 5)
						System.out.println("La gravedad solo puuede ser entre 1 y 5");
				} while (gravedad < 1 || gravedad > 5);
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		boolean enc = false;
		for (Paciente paciente : pacientes) {
			if (paciente instanceof PacienteUrgencias) {
				if (((PacienteUrgencias) paciente).getGravedad() == gravedad) {
					((PacienteUrgencias) paciente).mostrarDatos();
					enc = true;
				}
			}
		}
		
		if(!enc)
			System.out.println("No hay pacientes con el nivel de gravedad " + gravedad);

	}

}