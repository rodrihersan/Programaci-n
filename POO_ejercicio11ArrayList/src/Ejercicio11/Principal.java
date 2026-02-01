package Ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// Cambiamos el array fijo por un ArrayList
		ArrayList<Cliente> club = new ArrayList<Cliente>();
		boolean salir = false;

		do {
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
				case 4: añadirPuntos(club); break;
				case 5: canjearPuntos(club); break;
				case 6: filtrarTipo(club); break;
				case 7: clienteEstrella(club); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrar(ArrayList<Cliente> club) throws IOException {
		// El enunciado pedía límite de 25
		if (club.size() < 25) {
			Cliente nuevo = new Cliente();
			nuevo.pedirDatos(club);
			club.add(nuevo);
			System.out.println("Socio registrado correctamente.");
		} else {
			System.out.println("Error: El club está lleno (límite 25).");
		}
	}

	private static void mostrarTodo(ArrayList<Cliente> club) {
		if (club.isEmpty()) System.out.println("No hay socios registrados.");
		for (Cliente c : club) {
			System.out.println(c.toString());
		}
	}

	private static void buscarSocio(ArrayList<Cliente> club) throws IOException {
		System.out.print("Número de socio: ");
		int num = leerIntPositivo();
		for (Cliente c : club) {
			if (c.getNumeroSocio() == num) {
				System.out.println(c.toString());
				return;
			}
		}
		System.out.println("Socio no encontrado.");
	}

	private static void añadirPuntos(ArrayList<Cliente> club) throws IOException {
		System.out.print("Número de socio: ");
		int num = leerIntPositivo();
		for (Cliente c : club) {
			if (c.getNumeroSocio() == num) {
				System.out.print("Cantidad a sumar: ");
				c.sumarPuntos(leerIntPositivo());
				System.out.println("Saldo actualizado.");
				return;
			}
		}
		System.out.println("No encontrado.");
	}

	private static void canjearPuntos(ArrayList<Cliente> club) throws IOException {
		System.out.print("Número de socio: ");
		int num = leerIntPositivo();
		for (Cliente c : club) {
			if (c.getNumeroSocio() == num) {
				System.out.print("Puntos a canjear: ");
				int pts = leerIntPositivo();
				if (c.canjearPuntos(pts)) System.out.println("Canje realizado.");
				else System.out.println("Saldo insuficiente. Tiene: " + c.getPuntos());
				return;
			}
		}
		System.out.println("No encontrado.");
	}

	private static void filtrarTipo(ArrayList<Cliente> club) throws IOException {
		System.out.print("Tipo (normal/premium/vip): ");
		String tipo = leerLinea().toLowerCase();
		for (Cliente c : club) {
			if (c.getTipo().equals(tipo)) {
				System.out.println(c.toString());
			}
		}
	}

	private static void clienteEstrella(ArrayList<Cliente> club) {
		if (club.isEmpty()) return;
		Cliente estrella = club.get(0);
		for (Cliente c : club) {
			if (c.getPuntos() > estrella.getPuntos()) {
				estrella = c;
			}
		}
		System.out.println("CLIENTE ESTRELLA: " + estrella.toString());
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