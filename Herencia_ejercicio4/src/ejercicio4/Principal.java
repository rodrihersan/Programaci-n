package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Trabajador> empleados = new ArrayList<Trabajador>();

		boolean salir = false;
		do {
			System.out.println("=== PLANTILLA TRABAJADORES ===");
			System.out.println("1. Añadir empleado completo");
			System.out.println("2. Añadir empledo temporal");
			System.out.println("3. Calcular salario");
			System.out.println("4. Mostrar todos los datos");
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
				System.out.println("=== Crar curenta ahorro ===");
				añadirEmpleadoCompleto(empleados);
				break;
			case 2:
				System.out.println("=== Crar cuenta corriente ===");
				añadirEmpleadoTemporal(empleados);
				break;
			case 3:
				System.out.println("=== Depositar dinero en una cuenta ===");
				calcularSalario(empleados);
				break;
			case 4:
				System.out.println("=== Retirar dinero de una cuenta ===");
				mostrarDatos(empleados);
			case 5:
				System.out.println("=== Aplicar interes ===");
				mostrarDatos(empleados);
			case 6:
				System.out.println("=== Mostrar los datos ===");
				mostrarDatos(empleados);
			case 7:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}
	
	private static void depositarDinero() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce dinero a depositar: ");
		double dineroADepositar
	}

}
