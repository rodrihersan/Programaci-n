package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Cliente[] club = new Cliente[25];
		boolean salir = false;

		do {
			System.out.println("== CLUB FIDELIZACIÓN ==");
			System.out.println("1. Registrar cliente");
			System.out.println("2. Mostrar todos");
			System.out.println("3. Buscar por socioI");
			System.out.println("4. Añadir puntos");
			System.out.println("5. Canjear puntos");
			System.out.println("6. Mostrar por tipo");
			System.out.println("7. Cliente estrella");
			System.out.println("8. Salir");
			System.out.print("Opción: ");
			
			int opcion = leerInt();

			switch (opcion) {
				case 1: registrar(club); break;
				case 2: mostrarTodo(club); break;
				case 3: buscarSocio(club); break;
				case 4: gestionarPuntos(club, true); break;
				case 5: gestionarPuntos(club, false); break;
				case 6: filtrarTipo(club); break;
				case 7: clienteEstrella(club); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrar(Cliente[] club) throws IOException {
		boolean hueco = false;
		for (int i = 0; i < club.length && !hueco; i++) {
			if (club[i] == null) {
				Cliente nuevo = new Cliente();
				nuevo.pedirDatos(club);
				club[i] = nuevo;
				hueco = true;
				System.out.println("Cliente guardado.");
			}
		}
		if (!hueco) System.out.println("No queda espacio en el club.");
	}

	private static void mostrarTodo(Cliente[] club) {
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null) System.out.println(club[i].toString());
		}
	}

	private static void buscarSocio(Cliente[] club) throws IOException {
		System.out.print("Número de socio: ");
		int num = leerIntPositivo();
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null && club[i].getNumeroSocio() == num) {
				System.out.println(club[i].toString());
				return;
			}
		}
		System.out.println("Socio no encontrado.");
	}

	private static void gestionarPuntos(Cliente[] club, boolean sumar) throws IOException {
		System.out.print("Número de socio: ");
		int num = leerIntPositivo();
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null && club[i].getNumeroSocio() == num) {
				System.out.print("Cantidad de puntos: ");
				int pts = leerIntPositivo();
				if (sumar) {
					club[i].sumarPuntos(pts);
					System.out.println("Puntos añadidos.");
				} else {
					if (club[i].canjearPuntos(pts)) System.out.println("Puntos canjeados.");
					else System.out.println("Error: Saldo insuficiente (" + club[i].getPuntos() + " actuales).");
				}
				return;
			}
		}
		System.out.println("No existe ese socio.");
	}

	private static void filtrarTipo(Cliente[] club) throws IOException {
		System.out.print("Tipo a buscar (normal/premium/vip): ");
		String busca = leerLinea().toLowerCase();
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null && club[i].getTipo().equals(busca)) {
				System.out.println(club[i].toString());
			}
		}
	}

	private static void clienteEstrella(Cliente[] club) {
		Cliente estrella = null;
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null) {
				if (estrella == null || club[i].getPuntos() > estrella.getPuntos()) {
					estrella = club[i];
				}
			}
		}
		if (estrella != null) System.out.println("CLIENTE ESTRELLA: " + estrella.toString());
		else System.out.println("No hay clientes.");
	}

	// --- MÉTODOS AUXILIARES ---
	public static int leerInt() throws IOException {
		int n = 0; boolean ok = false;
		while (!ok) {
			try { n = Integer.parseInt(LEER.readLine()); ok = true;
			} catch (Exception e) { System.out.print("Pon un número: "); }
		}
		return n;
	}

	public static int leerIntPositivo() throws IOException {
		int n = leerInt();
		while (n < 0) { System.out.print("No negativo: "); n = leerInt(); }
		return n;
	}

	public static String leerLinea() throws IOException {
		String t;
		do {
			t = LEER.readLine().trim();
			if (t.isEmpty()) System.out.print("Escribe algo: ");
			else break;
		} while (true);
		return t;
	}
}