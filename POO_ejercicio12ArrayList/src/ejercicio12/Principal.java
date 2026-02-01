package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		ArrayList<Habitacion> hotel = new ArrayList<Habitacion>();
		boolean salir = false;

		do {
			System.out.println("== GESTIÓN HOTEL ==");
			System.out.println("1. Registrar habitación");
			System.out.println("2. Mostrar todas");
			System.out.println("3. Ocupar habitación");
			System.out.println("4. Liberar habitación");
			System.out.println("5. Mostrar libres");
			System.out.println("6. Mostrar por tipo");
			System.out.println("7. Calcular ingresos");
			System.out.println("8. Salir");
			System.out.print("Opción: ");
			int opcion = leerInt();

			switch (opcion) {
				case 1: registrar(hotel); break;
				case 2: mostrarTodo(hotel); break;
				case 3: realizarCheckIn(hotel); break;
				case 4: realizarCheckOut(hotel); break;
				case 5: mostrarLibres(hotel); break;
				case 6: filtrarTipo(hotel); break;
				case 7: ingresosActuales(hotel); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrar(ArrayList<Habitacion> hotel) throws IOException {
		if (hotel.size() < 30) {
			Habitacion h = new Habitacion();
			h.pedirDatos(hotel);
			hotel.add(h);
			System.out.println("Habitación registrada.");
		} else {
			System.out.println("Error: El hotel está completo.");
		}
	}

	private static void mostrarTodo(ArrayList<Habitacion> hotel) {
		if (hotel.isEmpty()) System.out.println("No hay habitaciones.");
		for (Habitacion h : hotel) System.out.println(h.toString());
	}

	private static void realizarCheckIn(ArrayList<Habitacion> hotel) throws IOException {
		System.out.print("Código de habitación: ");
		int cod = leerIntPositivo();
		for (Habitacion h : hotel) {
			if (h.getCodigo() == cod) {
				System.out.print("Nombre del huésped: ");
				String nombre = leerLinea();
				h.ocupar(nombre);
				return;
			}
		}
		System.out.println("Habitación no encontrada.");
	}

	private static void realizarCheckOut(ArrayList<Habitacion> hotel) throws IOException {
		System.out.print("Código de habitación: ");
		int cod = leerIntPositivo();
		for (Habitacion h : hotel) {
			if (h.getCodigo() == cod) {
				h.liberar();
				return;
			}
		}
		System.out.println("Código incorrecto.");
	}

	private static void mostrarLibres(ArrayList<Habitacion> hotel) {
		for (Habitacion h : hotel) {
			if (!h.isOcupada()) System.out.println(h.toString());
		}
	}

	private static void filtrarTipo(ArrayList<Habitacion> hotel) throws IOException {
		System.out.print("Tipo (individual/doble/suite): ");
		String busca = leerLinea().toLowerCase();
		for (Habitacion h : hotel) {
			if (h.getTipo().equals(busca)) System.out.println(h.toString());
		}
	}

	private static void ingresosActuales(ArrayList<Habitacion> hotel) {
		double total = 0;
		for (Habitacion h : hotel) {
			if (h.isOcupada()) {
				total = total + h.getPrecioNoche();
			}
		}
		System.out.println("Ingresos por noche de las habitaciones ocupadas: " + total + "€");
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

	public static double leerDoublePositivo() throws IOException {
		double n = 0; boolean ok = false;
		while (!ok) {
			try { 
				n = Double.parseDouble(LEER.readLine());
				if (n >= 0) ok = true; else System.out.print("No negativo: ");
			} catch (Exception e) { System.out.print("Pon un número: "); }
		}
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