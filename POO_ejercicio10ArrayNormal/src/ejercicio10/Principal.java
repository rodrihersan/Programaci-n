package ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// Array normal de 15 posiciones
		Empleado[] plantilla = new Empleado[15];
		boolean salir = false;

		do {
			System.out.println("== RRHH - GESTIÓN DE EMPLEADOS ==");
			System.out.println("1. Contratar empleado");
			System.out.println("2. Mostrar todos");
			System.out.println("3. Buscar por DNI");
			System.out.println("4. Mostrar por departamento");
			System.out.println("5. Aumentar salario");
			System.out.println("6. Mostrar salario máximo");
			System.out.println("7. Salir");
			System.out.print("Opción: ");
			
			int opcion = leerInt();

			switch (opcion) {
				case 1: contratar(plantilla); break;
				case 2: mostrarTodo(plantilla); break;
				case 3: buscarDni(plantilla); break;
				case 4: filtrarDepartamento(plantilla); break;
				case 5: subirSueldo(plantilla); break;
				case 6: salarioMaximo(plantilla); break;
				case 7: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void contratar(Empleado[] plantilla) throws IOException {
		boolean huecoEncontrado = false;
		for (int i = 0; i < plantilla.length && !huecoEncontrado; i++) {
			if (plantilla[i] == null) {
				Empleado nuevo = new Empleado();
				nuevo.pedirDatos(plantilla);
				plantilla[i] = nuevo;
				huecoEncontrado = true;
				System.out.println("Empleado contratado en la posición " + i);
			}
		}
		if (!huecoEncontrado) System.out.println("Error: No hay huecos libres (Máx 15).");
	}

	private static void mostrarTodo(Empleado[] plantilla) {
		boolean vacio = true;
		for (int i = 0; i < plantilla.length; i++) {
			if (plantilla[i] != null) {
				System.out.println(plantilla[i].toString());
				vacio = false;
			}
		}
		if (vacio) System.out.println("La plantilla está vacía.");
	}

	private static void buscarDni(Empleado[] plantilla) throws IOException {
		System.out.print("DNI a buscar: ");
		String busca = leerLinea();
		for (int i = 0; i < plantilla.length; i++) {
			if (plantilla[i] != null && plantilla[i].getDni().equals(busca)) {
				System.out.println("Encontrado: " + plantilla[i].toString());
				return;
			}
		}
		System.out.println("DNI no encontrado.");
	}

	private static void filtrarDepartamento(Empleado[] plantilla) throws IOException {
		System.out.print("Departamento: ");
		String depBusca = leerLinea().toLowerCase();
		for (int i = 0; i < plantilla.length; i++) {
			if (plantilla[i] != null && plantilla[i].getDepartamento().equals(depBusca)) {
				System.out.println(plantilla[i].toString());
			}
		}
	}

	private static void subirSueldo(Empleado[] plantilla) throws IOException {
		System.out.print("DNI del empleado: ");
		String busca = leerLinea();
		for (int i = 0; i < plantilla.length; i++) {
			if (plantilla[i] != null && plantilla[i].getDni().equals(busca)) {
				System.out.print("Porcentaje de aumento: ");
				double p = leerDoublePositivo();
				plantilla[i].aumentarSalario(p);
				System.out.println("Sueldo actualizado.");
				return;
			}
		}
		System.out.println("No se encontró el DNI.");
	}

	private static void salarioMaximo(Empleado[] plantilla) {
		Empleado maximo = null;
		for (int i = 0; i < plantilla.length; i++) {
			if (plantilla[i] != null) {
				if (maximo == null || plantilla[i].getSalario() > maximo.getSalario()) {
					maximo = plantilla[i];
				}
			}
		}
		if (maximo != null) System.out.println("Salario máximo: " + maximo.toString());
		else System.out.println("No hay empleados.");
	}

	// --- TUS MÉTODOS AUXILIARES ---
	public static int leerInt() throws IOException {
		int num = 0; boolean ok = false;
		while (!ok) {
			try { num = Integer.parseInt(LEER.readLine()); ok = true;
			} catch (Exception e) { System.out.print("Pon un número: "); }
		}
		return num;
	}

	public static double leerDoublePositivo() throws IOException {
		double n = 0; boolean ok = false;
		while (!ok) {
			try {
				n = Double.parseDouble(LEER.readLine());
				if (n >= 0) ok = true;
				else System.out.print("No negativo: ");
			} catch (Exception e) { System.out.print("Número inválido: "); }
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