package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Trabajador> empleados = new ArrayList<Trabajador>();

		boolean salir = false;
		do {
			System.out.println("\n=== PLANTILLA TRABAJADORES ===");
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
				System.out.println("=== Añadir empleado completo ===");
				añadirEmpleadoCompleto(empleados);
				break;
			case 2:
				System.out.println("=== Añadir empledo temporal ===");
				añadirEmpleadoTemporal(empleados);
				break;
			case 3:
				System.out.println("=== Calcular salario ===");
				calcularSalario(empleados);
				break;
			case 4:
				System.out.println("===Mostrar todos los datos===");
				mostrarDatos(empleados);
			case 5:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void añadirEmpleadoCompleto(ArrayList<Trabajador> empleados) {
		int id = 1;
		if (empleados.size() > 0)
			id = empleados.getLast().getId() + 1;
		TrabajadorCompleto trabajadorComp = new TrabajadorCompleto();
		trabajadorComp.pedirDatos(id);
		empleados.add(trabajadorComp);

	}
	private static void añadirEmpleadoTemporal(ArrayList<Trabajador> empleados) {
		int id = 1;
		if (empleados.size() > 0)
			id = empleados.getLast().getId() + 1;
		TrabajadorTemporal trabajadorTemp = new TrabajadorTemporal();
		trabajadorTemp.pedirDatos(id);
		empleados.add(trabajadorTemp);

	}
	

	private static void calcularSalario(ArrayList<Trabajador> empleados) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del empleado: ");
				idABuscar = Integer.parseInt(leer.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			datosOK = true;
		}
		
		for(Trabajador emp: empleados) {
			if(emp.getId() == idABuscar) {
				if(emp instanceof TrabajadorCompleto)
					System.out.println("El salario del empleado es: " + ((TrabajadorCompleto)emp).salario());
					
				else
					System.out.println("El salario del empleado es: " + ((TrabajadorTemporal)emp).salario());
			}
		}
		
		
		
	}
	
	private static void mostrarDatos(ArrayList<Trabajador> empleados) {
		for(Trabajador emp: empleados) {
			if(emp instanceof TrabajadorCompleto)
				((TrabajadorCompleto)emp).mostrarDatos();
				
			else
				((TrabajadorTemporal)emp).mostrarDatos();
			
		}
	}

}
