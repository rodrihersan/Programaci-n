package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		EmpleadoHoras[] empleados = new EmpleadoHoras[10];
		boolean salir = false;

		do {
			System.out.println("== GESTION EMPLEADOS ==");
			System.out.println("1. Registrar empleado");
			System.out.println("2. Registrar horas");
			System.out.println("3. Ver semana");
			System.out.println("4. Calcular salario");
			System.out.println("5. Empleado del mes");
			System.out.println("6. Alerta descansos");
			System.out.println("7. Salir");
			System.out.print("Introduce una opcion: ");
			
			int opcion = leerInt();

			switch (opcion) {
				case 1: registrarEmpleado(empleados); break;
				case 2: añadirHoras(empleados); break;
				case 3: verSemana(empleados); break;
				case 4: calcularSueldo(empleados); break;
				case 5: empleadoDelMes(empleados); break;
				case 6: alertaDescansos(empleados); break;
				case 7: salir = true; break;
				default: System.out.println("Opción no válida.");
			}
		} while (!salir);
	}

	private static void registrarEmpleado(EmpleadoHoras[] empleados) throws IOException {
		boolean hueco = false;
		for (int i = 0; i < empleados.length && !hueco; i++) {
			if (empleados[i] == null) {
				EmpleadoHoras e = new EmpleadoHoras();
				e.pedirDatos(empleados);
				empleados[i] = e;
				hueco = true;
			}
		}
		if (!hueco) System.out.println("No hay espacio para más empleados.");
	}

	private static void añadirHoras(EmpleadoHoras[] empleados) throws IOException {
		System.out.print("Introduce ID: ");
		int idBusca = leerIntPositivo();
		boolean enc = false;
		for (EmpleadoHoras e : empleados) {
			if (e != null && e.getId() == idBusca) {
				e.registrarHoras();
				enc = true;
			}
		}
		if (!enc) System.out.println("ID no encontrado.");
	}

	private static void verSemana(EmpleadoHoras[] empleados) throws IOException {
		System.out.print("Introduce ID: ");
		int idBusca = leerIntPositivo();
		for (EmpleadoHoras e : empleados) {
			if (e != null && e.getId() == idBusca) {
				System.out.println(e.toString());
				System.out.println("Total horas: " + e.calcularSumatorio());
			}
		}
	}

	private static void calcularSueldo(EmpleadoHoras[] empleados) throws IOException {
		System.out.print("Introduce ID: ");
		int idBusca = leerIntPositivo();
		for (EmpleadoHoras e : empleados) {
			if (e != null && e.getId() == idBusca) {
				System.out.println("Salario semanal de " + e.getNombre() + ": " + e.calcularSalario() + "€");
			}
		}
	}

	private static void empleadoDelMes(EmpleadoHoras[] empleados) {
		double max = -1;
		EmpleadoHoras top = null;
		for (EmpleadoHoras e : empleados) {
			if (e != null && e.calcularSumatorio() > max) {
				max = e.calcularSumatorio();
				top = e;
			}
		}
		if (top != null) System.out.println("Empleado con más horas: " + top.getNombre() + " (" + max + "h)");
	}

	private static void alertaDescansos(EmpleadoHoras[] empleados) {
		System.out.println("== EMPLEADOS QUE NO HAN TRABAJADO ALGÚN DÍA ==");
		for (EmpleadoHoras e : empleados) {
			if (e != null && e.contarDiasLibres() > 0) {
				System.out.println("Empleado: " + e.getNombre() + " (ID: " + e.getId() + ") Días no trabajados: " + e.contarDiasLibres());
			}
		}
	}

	// --- TUS MÉTODOS AUXILIARES ---
	public static int leerInt() throws IOException {
		int num = 0; boolean valido = false;
		while (!valido) {
			try { num = Integer.parseInt(LEER.readLine()); valido = true;
			} catch (Exception e) { System.out.print("ERROR. Introduce un número válido: "); }
		}
		return num;
	}

	public static int leerIntPositivo() throws IOException {
		int n = leerInt();
		while (n < 0) { System.out.print("ERROR. No puede ser negativo: "); n = leerInt(); }
		return n;
	}

	public static double leerDouble() throws IOException {
		double n = 0; boolean v = false;
		while (!v) {
			try { n = Double.parseDouble(LEER.readLine()); v = true;
			} catch (Exception e) { System.out.print("ERROR. Introduce un número: "); }
		}
		return n;
	}

	public static double leerDoublePositivo() throws IOException {
		double n = leerDouble();
		while (n < 0) { System.out.print("No negativo. Reintenta: "); n = leerDouble(); }
		return n;
	}

	public static String leerLinea() throws IOException {
		String t;
		do {
			t = LEER.readLine().trim();
			if (t.isEmpty()) System.out.print("Escribe algo: ");
			else if (!esTextoValido(t)) System.out.print("Solo letras: ");
			else break;
		} while (true);
		return t;
	}

	public static boolean esTextoValido(String t) {
		for (char c : t.toCharArray()) {
			if (!Character.isLetter(c)) return false;
		}
		return true;
	}
}