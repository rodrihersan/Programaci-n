package ejercicio16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ArrayList<EmpleadoHoras> empleados = new ArrayList<EmpleadoHoras>();
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
			
			System.out.println("Introduce una opcion: ");
			
			int opcion = -1;
			try {
				opcion = Integer.parseInt(LEER.readLine());
			} catch (Exception e) {
				System.out.println("Introduce un numero");
			}

			switch (opcion) {
				case 1: registrarEmpleado(empleados); break;
				case 2: añadirHoras(empleados); break;
				case 3: verSemana(empleados); break;
				case 4: calcularSueldo(empleados); break;
				case 5: empleadoDelMes(empleados); break;
				case 6: alertaDescansos(empleados); break;
				case 7: salir = true; break;
				default:System.out.println("Opcion no valida");break;
			}
		} while (!salir);
	}

	private static void registrarEmpleado(ArrayList<EmpleadoHoras> empleados) {
		if (empleados.size() < 10) { // Esto es lo que controla el límite que pide el enunciado
	        EmpleadoHoras e = new EmpleadoHoras();
	        e.pedirDatos(empleados);
	        empleados.add(e);
	    } else {
	        System.out.println("Error: No caben más de 10 empleados");
	    }
	}

	private static void añadirHoras(ArrayList<EmpleadoHoras> empleados) {
		System.out.println("Introduce ID: ");
		try {
			int idBusca = Integer.parseInt(LEER.readLine());
			boolean enc = false;
			// Recorremos con el for-each que usas en Alumno
			for (EmpleadoHoras e : empleados) {
				if (e.getId() == idBusca) {
					e.registrarHoras();
					enc = true;
				}
			}
			if (!enc) System.out.println("No encontrado");
		} catch (Exception e) { }
	}

	private static void verSemana(ArrayList<EmpleadoHoras> empleados) {
		System.out.println("Introduce ID: ");
		try {
			int idBusca = Integer.parseInt(LEER.readLine());
			for (EmpleadoHoras e : empleados) {
				if (e.getId() == idBusca) {
					System.out.println(e.toString());
					System.out.println("Total horas: " + e.calcularSumatorio());
				}
			}
		} catch (Exception e) { }
	}

	private static void calcularSueldo(ArrayList<EmpleadoHoras> empleados) {
		System.out.println("Introduce ID: ");
		try {
			int idBusca = Integer.parseInt(LEER.readLine());
			for (EmpleadoHoras e : empleados) {
				if (e.getId() == idBusca) {
					System.out.println("Sueldo: " + e.calcularSalario());
				}
			}
		} catch (Exception e) { }
	}

	private static void empleadoDelMes(ArrayList<EmpleadoHoras> empleados) {
		double max = -1;
		EmpleadoHoras top = null;
		for (EmpleadoHoras e : empleados) {
			if (e.calcularSumatorio() > max) {
				max = e.calcularSumatorio();
				top = e;
			}
		}
		if (top != null) System.out.println("El mejor es: " + top.getNombre());
	}

	private static void alertaDescansos(ArrayList<EmpleadoHoras> empleados) {
	    System.out.println("== LISTADO DE EMPLEADOS QUE NO HAN TRABAJADO ALGÚN DÍA ==");
	    
	    for (int i = 0; i < empleados.size(); i++) {
	        int diasLibres = empleados.get(i).contarDiasLibres();
	        
	        // Si el contador es mayor que 0, significa que algún día no trabajó
	        if (diasLibres > 0) {
	            System.out.println("Empleado: " + empleados.get(i).getNombre() + 
	                               " (ID: " + empleados.get(i).getId() + ") " +
	                               "Dias no trabajados: " + diasLibres);
	        }
	    }
	}
}