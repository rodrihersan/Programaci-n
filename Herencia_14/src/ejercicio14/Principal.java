package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		boolean salir = false;
		do {
			System.out.println("\n=== AGENCIA DE EVENTOS ===");
			System.out.println("1. Organizar Nuevo Evento");
			System.out.println("2. Registrar Asistente a Concierto");
			System.out.println("3. Inscribir en Conferencia");
			System.out.println("4. Localizar Asistente");
			System.out.println("5. Informe de Recaudación");
			System.out.println("6. Evento más Multitudinario");
			System.out.println("7. Salir");
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
				System.out.println("=== Organizar Nuevo Evento ===");
				organizarEvento(eventos);
				break;
			case 2:
				System.out.println("=== Registrar Asistente a Concierto ===");
				registrarAsistenteConcierto(eventos);
				break;
			case 3:
				System.out.println("=== Inscribir en Conferencia ===");
				inscribirConferencia(eventos);
				break;
			case 4:
				System.out.println("=== Localizar Asistente ===");
				localizarAsistente(eventos);
				break;
			case 5:
				System.out.println("=== Informe de Recaudación ===");
				informeRecaudacion(eventos);
				break;
			case 6:
				System.out.println("=== Evento más Multitudinario ===");
				eventoMasMultitudinario(eventos);
				break;
			case 7:
				salir = true;
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void organizarEvento(ArrayList<Evento> eventos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoEvento = "";
		do {
			try {
				System.out.print("Introduce el tipo de evento (Concierto o Conferencia): ");
				tipoEvento = leer.readLine();

				if (!tipoEvento.equalsIgnoreCase("concierto") && !tipoEvento.equalsIgnoreCase("conferencia")) {
					System.out.println("El tipo de evento no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoEvento.equalsIgnoreCase("concierto") && !tipoEvento.equalsIgnoreCase("conferencia"));

		int id = 1;
		if (eventos.size() > 0)
			id = eventos.getLast().getId() + 1;

		if (tipoEvento.equalsIgnoreCase("concierto")) {
			Concierto concierto = new Concierto();
			concierto.pedirDatos(id);
			eventos.add(concierto);
		} else {
			Conferencia conferencia = new Conferencia();
			conferencia.pedirDatos(id);
			eventos.add(conferencia);
		}

		System.out.println("Evento registrado correctamente con ID: " + id);
	}

	private static Evento buscarEventoPorId(ArrayList<Evento> eventos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idEvento = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el ID del evento: ");
				idEvento = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		for (Evento evento : eventos) {
			if (evento.getId() == idEvento) {
				return evento;
			}
		}

		System.out.println("No se ha encontrado el evento");
		return null;
	}

	private static void registrarAsistenteConcierto(ArrayList<Evento> eventos) {
		Evento evento = buscarEventoPorId(eventos);

		if (evento != null) {
			if (evento instanceof Concierto) {
				if (((Concierto) evento).añadirAsistente()) {
					System.out.println("Asistente registrado correctamente");
				}
			} else {
				System.out.println("El evento no es un concierto");
			}
		}
	}

	private static void inscribirConferencia(ArrayList<Evento> eventos) {
		Evento evento = buscarEventoPorId(eventos);

		if (evento != null) {
			if (evento instanceof Conferencia) {
				if (((Conferencia) evento).añadirParticipante()) {
					System.out.println("Participante inscrito correctamente");
				}
			} else {
				System.out.println("El evento no es una conferencia");
			}
		}
	}

	private static void localizarAsistente(ArrayList<Evento> eventos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";

		try {
			System.out.print("Introduce el nombre de la persona a buscar: ");
			nombre = leer.readLine();
		} catch (IOException e) {
			System.err.println("Ha habido un error");
			return;
		}

		boolean enc = false;
		for (Evento evento : eventos) {
			if (evento instanceof Concierto) {
				if (((Concierto) evento).buscarAsistente(nombre)) {
					System.out.println("Persona encontrada en el evento: ");
					evento.mostrarDatos();
					enc = true;
				}
			} else if (evento instanceof Conferencia) {
				if (((Conferencia) evento).buscarParticipante(nombre)) {
					System.out.println("Persona encontrada en el evento: ");
					evento.mostrarDatos();
					enc = true;
				}
			}
		}

		if (!enc)
			System.out.println("No se ha encontrado la persona en ningún evento");
	}

	private static void informeRecaudacion(ArrayList<Evento> eventos) {
		Evento evento = buscarEventoPorId(eventos);

		if (evento != null) {
			if (evento instanceof Concierto) {
				System.out.println("Recaudación total: " + ((Concierto) evento).calcularRecaudacion());
			} else if (evento instanceof Conferencia) {
				System.out.println("Recaudación total: " + ((Conferencia) evento).calcularRecaudacion());
			}
		}
	}

	private static void eventoMasMultitudinario(ArrayList<Evento> eventos) {
		if (eventos.size() == 0) {
			System.out.println("No hay eventos registrados");
			return;
		}

		Evento masLleno = eventos.get(0);
		for (Evento evento : eventos) {
			if (evento.getNumAsistentes() > masLleno.getNumAsistentes()) {
				masLleno = evento;
			}
		}

		System.out.println("=== Evento con más asistentes ===");
		masLleno.mostrarDatos();
	}

}