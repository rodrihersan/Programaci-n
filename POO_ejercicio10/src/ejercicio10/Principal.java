package ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	// Scanner centralizado para todos los métodos
	public static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		ArrayList<Empleado> plantilla = new ArrayList<Empleado>();
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
				default: System.out.println("Opción no válida."); break;
			}
		} while (!salir);
	}

	private static void contratar(ArrayList<Empleado> plantilla) throws IOException {
		// Límite de 15 empleados según el enunciado
		if (plantilla.size() < 15) {
			Empleado nuevo = new Empleado(); 
			nuevo.pedirDatos(plantilla); // El objeto se encarga de rellenarse
			plantilla.add(nuevo);
			System.out.println("Contratación finalizada con éxito.");
		} else {
			System.out.println("Error: No se pueden contratar más de 15 empleados.");
		}
	}

	private static void mostrarTodo(ArrayList<Empleado> plantilla) {
		if (plantilla.isEmpty()) {
			System.out.println("No hay empleados registrados actualmente.");
		} else {
			System.out.println("== LISTADO COMPLETO DE EMPLEADOS ==");
			for (Empleado e : plantilla) {
				System.out.println(e.toString());
			}
		}
	}

	private static void buscarDni(ArrayList<Empleado> plantilla) throws IOException {
		System.out.print("Introduce el DNI a buscar: ");
		String busca = leerLinea();
		boolean encontrado = false;
		
		for (Empleado e : plantilla) {
			if (e.getDni().equals(busca)) {
				System.out.println("Ficha encontrada: " + e.toString());
				encontrado = true;
				break;
			}
		}
		if (!encontrado) System.out.println("No existe ningún empleado con ese DNI.");
	}

	private static void filtrarDepartamento(ArrayList<Empleado> plantilla) throws IOException {
		System.out.print("Introduce departamento (ventas/marketing/produccion/administracion): ");
		String depBusca = leerLinea().toLowerCase();
		
		System.out.println("== EMPLEADOS EN " + depBusca.toUpperCase() + " ==");
		boolean hayEmpleados = false;
		for (Empleado e : plantilla) {
			if (e.getDepartamento().equals(depBusca)) {
				System.out.println(e.toString());
				hayEmpleados = true;
			}
		}
		if (!hayEmpleados) System.out.println("No hay empleados en este departamento.");
	}

	private static void subirSueldo(ArrayList<Empleado> plantilla) throws IOException {
		System.out.print("Introduce DNI del empleado: ");
		String busca = leerLinea();
		boolean encontrado = false;
		
		for (Empleado e : plantilla) {
			if (e.getDni().equals(busca)) {
				System.out.print("Introduce porcentaje de aumento: ");
				double porc = leerDoublePositivo();
				e.aumentarSalario(porc);
				System.out.println("Salario actualizado correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado) System.out.println("Empleado no encontrado.");
	}

	private static void salarioMaximo(ArrayList<Empleado> plantilla) {
		if (plantilla.isEmpty()) {
			System.out.println("No hay datos suficientes.");
			return;
		}
		
		Empleado maximo = plantilla.get(0);
		for (Empleado e : plantilla) {
			if (e.getSalario() > maximo.getSalario()) {
				maximo = e;
			}
		}
		System.out.println("EMPLEADO CON SALARIO MÁXIMO:");
		System.out.println(maximo.toString());
	}

	// --- TUS MÉTODOS AUXILIARES ---

	public static int leerInt() throws IOException {
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(LEER.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.out.print("ERROR. Introduce un número válido: ");
			}
		}
		return num;
	}

	public static double leerDoublePositivo() throws IOException {
		double numero = 0;
		boolean valido = false;
		while (!valido) {
			try {
				numero = Double.parseDouble(LEER.readLine());
				if (numero >= 0) {
					valido = true;
				} else {
					System.out.print("ERROR. No puede ser negativo: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("ERROR. Introduce un número válido: ");
			}
		}
		return numero;
	}

	public static String leerLinea() throws IOException {
		String texto;
		do {
			texto = LEER.readLine().trim();
			if (texto.isEmpty()) {
				System.out.print("Debes escribir algo: ");
			} else {
				break;
			}
		} while (true);
		return texto;
	}
}
