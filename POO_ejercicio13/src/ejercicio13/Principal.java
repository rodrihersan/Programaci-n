package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// Definimos el Array de 20 objetos como pide el enunciado
		VehiculoAlquiler[] flota = new VehiculoAlquiler[20];
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
				case 2: mostrarFlota(flota); break;
				case 3: alquilarCoche(flota); break;
				case 4: devolverCoche(flota); break;
				case 5: filtrarPorCategoria(flota); break;
				case 6: calcularPresupuesto(flota); break;
				case 7: mostrarVIP(flota); break;
				case 8: salir = true; break;
				default: System.out.println("Opción no válida."); break;
			}
		} while (!salir);
	}

	private static void registrarVehiculo(VehiculoAlquiler[] flota) throws IOException {
		boolean registrado = false;
		for (int i = 0; i < flota.length && !registrado; i++) {
			if (flota[i] == null) {
				VehiculoAlquiler nuevo = new VehiculoAlquiler();
				nuevo.pedirDatos(flota);
				flota[i] = nuevo;
				registrado = true;
				System.out.println("Vehículo registrado correctamente.");
			}
		}
		if (!registrado) System.out.println("Error: La flota está llena.");
	}

	private static void mostrarFlota(VehiculoAlquiler[] flota) {
		System.out.println("== LISTADO DE LA FLOTA ==");
		for (VehiculoAlquiler v : flota) {
			if (v != null) System.out.println(v.toString());
		}
	}

	private static void alquilarCoche(VehiculoAlquiler[] flota) throws IOException {
		System.out.print("Introduce la matrícula del coche a alquilar: ");
		int mat = leerIntPositivo();
		boolean encontrado = false;
		for (VehiculoAlquiler v : flota) {
			if (v != null && v.getMatricula() == mat) {
				encontrado = true;
				if (!v.isAlquilado()) {
					v.setAlquilado(true);
					System.out.println("Alquiler realizado con éxito.");
				} else {
					System.out.println("Error: El vehículo ya está alquilado.");
				}
			}
		}
		if (!encontrado) System.out.println("No se encontró ningún vehículo con esa matrícula.");
	}

	private static void devolverCoche(VehiculoAlquiler[] flota) throws IOException {
		System.out.print("Introduce la matrícula del coche a devolver: ");
		int mat = leerIntPositivo();
		boolean encontrado = false;
		for (VehiculoAlquiler v : flota) {
			if (v != null && v.getMatricula() == mat) {
				encontrado = true;
				v.setAlquilado(false);
				System.out.println("El vehículo ha sido devuelto y ahora está LIBRE.");
			}
		}
		if (!encontrado) System.out.println("Matrícula no encontrada.");
	}

	private static void filtrarPorCategoria(VehiculoAlquiler[] flota) throws IOException {
		System.out.print("Introduce categoría (economico/estandar/lujo): ");
		String cat = leerLinea().toLowerCase();
		System.out.println("== DISPONIBLES EN CATEGORÍA: " + cat + " ==");
		for (VehiculoAlquiler v : flota) {
			if (v != null && v.getCategoria().equals(cat) && !v.isAlquilado()) {
				System.out.println(v.toString());
			}
		}
	}

	private static void calcularPresupuesto(VehiculoAlquiler[] flota) throws IOException {
		System.out.print("Introduce matrícula: ");
		int mat = leerIntPositivo();
		for (VehiculoAlquiler v : flota) {
			if (v != null && v.getMatricula() == mat) {
				System.out.print("¿Cuántos días de alquiler?: ");
				int dias = leerIntPositivo();
				System.out.println("Precio total para " + dias + " días: " + v.calcularPrecioFinal(dias) + "€");
				return;
			}
		}
		System.out.println("Vehículo no encontrado.");
	}

	private static void mostrarVIP(VehiculoAlquiler[] flota) {
		double maxPrecio = -1;
		VehiculoAlquiler vip = null;
		for (VehiculoAlquiler v : flota) {
			if (v != null && v.getPrecioDia() > maxPrecio) {
				maxPrecio = v.getPrecioDia();
				vip = v;
			}
		}
		if (vip != null) {
			System.out.println("== VEHÍCULO VIP (Más caro por día) ==");
			System.out.println(vip.toString());
		} else {
			System.out.println("No hay vehículos registrados.");
		}
	}

	// --- TUS MÉTODOS AUXILIARES ---
	public static int leerInt() throws IOException {
		int num = 0; boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(LEER.readLine());
				valido = true;
			} catch (Exception e) {
				System.out.print("ERROR. Introduce un número válido: ");
			}
		}
		return num;
	}

	public static int leerIntPositivo() throws IOException {
		int n = leerInt();
		while (n < 0) {
			System.out.print("ERROR. El número no puede ser negativo: ");
			n = leerInt();
		}
		return n;
	}

	public static double leerDoublePositivo() throws IOException {
		double n = 0; boolean v = false;
		while (!v) {
			try {
				n = Double.parseDouble(LEER.readLine());
				if (n >= 0) v = true;
				else System.out.print("Error: No puede ser negativo: ");
			} catch (Exception e) {
				System.out.print("ERROR. Introduce un número válido: ");
			}
		}
		return n;
	}

	public static String leerLinea() throws IOException {
		String t;
		do {
			t = LEER.readLine().trim();
			if (t.isEmpty()) System.out.print("Debes escribir algo: ");
			else break;
		} while (true);
		return t;
	}
}