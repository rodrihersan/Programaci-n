package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// Cambiamos el Array fijo por un ArrayList
		ArrayList<VehiculoAlquiler> flota = new ArrayList<VehiculoAlquiler>();
		boolean salir = false;

		do {
			System.out.println("--- GESTIÓN DE FLOTA DE VEHÍCULOS ---");
			System.out.println("1. Registrar vehículo");
			System.out.println("2. Mostrar todos");
			System.out.println("3. Alquilar vehículo");
			System.out.println("4. Devolver vehículo");
			System.out.println("5. Filtrar disponibles");
			System.out.println("6. Calcular presupuesto");
			System.out.println("7. Mostrar vehículo VIP");
			System.out.println("8. Salir");
			System.out.print("Elige una opción: ");
			
			int opcion = leerInt();

			switch (opcion) {
				case 1: registrarVehiculo(flota); break;
				case 2: mostrarTodo(flota); break;
				case 3: gestionarAlquiler(flota, true); break;
				case 4: gestionarAlquiler(flota, false); break;
				case 5: filtrarDisponibles(flota); break;
				case 6: calcularPresupuesto(flota); break;
				case 7: mostrarVIP(flota); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrarVehiculo(ArrayList<VehiculoAlquiler> flota) throws IOException {
		// Controlamos el límite de 20 con el size del ArrayList
		if (flota.size() < 20) {
			VehiculoAlquiler v = new VehiculoAlquiler();
			v.pedirDatos(flota);
			flota.add(v);
			System.out.println("Vehículo añadido con éxito.");
		} else {
			System.out.println("Error: La flota ya tiene 20 vehículos.");
		}
	}

	private static void mostrarTodo(ArrayList<VehiculoAlquiler> flota) {
		if (flota.isEmpty()) {
			System.out.println("No hay vehículos registrados.");
		} else {
			for (VehiculoAlquiler v : flota) {
				System.out.println(v.toString());
			}
		}
	}

	private static void gestionarAlquiler(ArrayList<VehiculoAlquiler> flota, boolean alquilar) throws IOException {
		System.out.print("Introduce matrícula: ");
		int mat = leerIntPositivo();
		boolean enc = false;
		for (VehiculoAlquiler v : flota) {
			if (v.getMatricula() == mat) {
				enc = true;
				if (alquilar) {
					if (!v.isAlquilado()) {
						v.setAlquilado(true);
						System.out.println("Alquilado correctamente.");
					} else System.out.println("Ya está alquilado.");
				} else {
					v.setAlquilado(false);
					System.out.println("Devuelto correctamente.");
				}
			}
		}
		if (!enc) System.out.println("Matrícula no encontrada.");
	}

	private static void filtrarDisponibles(ArrayList<VehiculoAlquiler> flota) throws IOException {
		System.out.print("Categoría a buscar: ");
		String cat = leerLinea().toLowerCase();
		for (VehiculoAlquiler v : flota) {
			if (v.getCategoria().equals(cat) && !v.isAlquilado()) {
				System.out.println(v.toString());
			}
		}
	}

	private static void calcularPresupuesto(ArrayList<VehiculoAlquiler> flota) throws IOException {
		System.out.print("Matrícula: ");
		int mat = leerIntPositivo();
		for (VehiculoAlquiler v : flota) {
			if (v.getMatricula() == mat) {
				System.out.print("Días de alquiler: ");
				int dias = leerIntPositivo();
				System.out.println("Precio total: " + v.calcularPrecioFinal(dias) + "€");
				return;
			}
		}
		System.out.println("No encontrado.");
	}

	private static void mostrarVIP(ArrayList<VehiculoAlquiler> flota) {
		double max = -1;
		VehiculoAlquiler vip = null;
		for (VehiculoAlquiler v : flota) {
			if (v.getPrecioDia() > max) {
				max = v.getPrecioDia();
				vip = v;
			}
		}
		if (vip != null) System.out.println("VIP: " + vip.toString());
	}

	// --- TUS MÉTODOS AUXILIARES ---
	public static int leerInt() throws IOException {
		int num = 0; boolean valido = false;
		while (!valido) {
			try { num = Integer.parseInt(LEER.readLine()); valido = true;
			} catch (Exception e) { System.out.print("Error, pon número: "); }
		}
		return num;
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