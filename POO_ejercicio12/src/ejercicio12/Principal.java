package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Habitacion[] hotel = new Habitacion[30];
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
				case 3: checkIn(hotel); break;
				case 4: checkOut(hotel); break;
				case 5: mostrarLibres(hotel); break;
				case 6: filtrarTipo(hotel); break;
				case 7: calcularIngresos(hotel); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrar(Habitacion[] hotel) throws IOException {
		boolean hueco = false;
		for (int i = 0; i < hotel.length && !hueco; i++) {
			if (hotel[i] == null) {
				Habitacion h = new Habitacion();
				h.pedirDatos(hotel);
				hotel[i] = h;
				hueco = true;
				System.out.println("Registrada con éxito.");
			}
		}
		if (!hueco) System.out.println("Hotel lleno.");
	}

	private static void mostrarTodo(Habitacion[] hotel) {
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null) System.out.println(hotel[i].toString());
		}
	}

	private static void checkIn(Habitacion[] hotel) throws IOException {
		System.out.print("Código: ");
		int cod = leerIntPositivo();
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && hotel[i].getCodigo() == cod) {
				System.out.print("Nombre cliente: ");
				hotel[i].ocupar(leerLinea());
				return;
			}
		}
		System.out.println("No existe ese código.");
	}

	private static void checkOut(Habitacion[] hotel) throws IOException {
		System.out.print("Código: ");
		int cod = leerIntPositivo();
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && hotel[i].getCodigo() == cod) {
				hotel[i].liberar();
				return;
			}
		}
		System.out.println("No existe ese código.");
	}

	private static void mostrarLibres(Habitacion[] hotel) {
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && !hotel[i].isOcupada()) {
				System.out.println(hotel[i].toString());
			}
		}
	}

	private static void filtrarTipo(Habitacion[] hotel) throws IOException {
		System.out.print("Tipo: ");
		String tipo = leerLinea().toLowerCase();
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && hotel[i].getTipo().equals(tipo)) {
				System.out.println(hotel[i].toString());
			}
		}
	}

	private static void calcularIngresos(Habitacion[] hotel) {
		double total = 0;
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && hotel[i].isOcupada()) {
				total = total + hotel[i].getPrecioNoche();
			}
		}
		System.out.println("Ingresos actuales: " + total + "€");
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
			try { n = Double.parseDouble(LEER.readLine());
				if (n >= 0) ok = true; else System.out.print("Positivo: ");
			} catch (Exception e) { System.out.print("Pon un número: "); }
		}
		return n;
	}

	public static String leerLinea() throws IOException {
		String t;
		do { t = LEER.readLine().trim();
			if (t.isEmpty()) System.out.print("Escribe algo: ");
			else break;
		} while (true);
		return t;
	}
}