package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		boolean salir = false;
		do {
			System.out.println("\n=== EMPRESA DE ALQUILER DE VEHICULOS ===");
			System.out.println("1. Registrar Vehiculo");
			System.out.println("2. Añadir Equipamiento a Coche");
			System.out.println("3. Añadir Extra a Furgoneta");
			System.out.println("4. Buscar Coches por Equipamiento");
			System.out.println("5. Calcular Presupuesto de Alquiler");
			System.out.println("6. Vehiculo Premium (Mas Caro)");
			System.out.println("7. Salir");
			System.out.print("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir numeros");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== Registrar Vehiculo ===");
				registrarVehiculo(vehiculos);
				break;
			case 2:
				System.out.println("=== Añadir Equipamiento a Coche ===");
				añadirEquipamientoCoche(vehiculos);
				break;
			case 3:
				System.out.println("=== Añadir Extra a Furgoneta ===");
				añadirExtraFurgoneta(vehiculos);
				break;
			case 4:
				System.out.println("=== Buscar Coches por Equipamiento ===");
				buscarCochesPorEquipamiento(vehiculos);
				break;
			case 5:
				System.out.println("=== Calcular Presupuesto de Alquiler ===");
				calcularPresupuesto(vehiculos);
				break;
			case 6:
				System.out.println("=== Vehiculo Premium ===");
				vehiculoPremium(vehiculos);
				break;
			case 7:
				salir = true;
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}

	private static void registrarVehiculo(ArrayList<Vehiculo> vehiculos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoVehiculo = "";
		do {
			try {
				System.out.print("Introduce el tipo de vehiculo (Coche o Furgoneta): ");
				tipoVehiculo = leer.readLine();

				if (!tipoVehiculo.equalsIgnoreCase("coche") && !tipoVehiculo.equalsIgnoreCase("furgoneta")) {
					System.out.println("El tipo de vehiculo no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoVehiculo.equalsIgnoreCase("coche") && !tipoVehiculo.equalsIgnoreCase("furgoneta"));

		if (tipoVehiculo.equalsIgnoreCase("coche")) {
			CocheAlquiler coche = new CocheAlquiler();
			coche.pedirDatos(vehiculos);
			vehiculos.add(coche);
		} else {
			FurgaAlquiler furgoneta = new FurgaAlquiler();
			furgoneta.pedirDatos(vehiculos);
			vehiculos.add(furgoneta);
		}

		System.out.println("Vehiculo registrado correctamente");
	}

	private static Vehiculo buscarVehiculoPorMatricula(ArrayList<Vehiculo> vehiculos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int matricula = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce la matricula del vehiculo: ");
				matricula = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir numeros");
			}
		}

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getMatricula() == matricula) {
				return vehiculo;
			}
		}

		System.out.println("No se ha encontrado el vehiculo");
		return null;
	}

	private static void añadirEquipamientoCoche(ArrayList<Vehiculo> vehiculos) {
		Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculos);

		if (vehiculo != null) {
			if (vehiculo instanceof CocheAlquiler) {
				if (((CocheAlquiler) vehiculo).añadirEquipamiento()) {
					System.out.println("Equipamiento añadido correctamente");
				}
			} else {
				System.out.println("El vehiculo no es un coche");
			}
		}
	}

	private static void añadirExtraFurgoneta(ArrayList<Vehiculo> vehiculos) {
		Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculos);

		if (vehiculo != null) {
			if (vehiculo instanceof FurgaAlquiler) {
				if (((FurgaAlquiler) vehiculo).añadirExtra()) {
					System.out.println("Extra añadido correctamente");
				}
			} else {
				System.out.println("El vehiculo no es una furgoneta");
			}
		}
	}

	private static void buscarCochesPorEquipamiento(ArrayList<Vehiculo> vehiculos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String elemento = "";

		try {
			System.out.print("Introduce el equipamiento a buscar: ");
			elemento = leer.readLine();
		} catch (IOException e) {
			System.err.println("Ha habido un error");
			return;
		}

		boolean enc = false;
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo instanceof CocheAlquiler) {
				if (((CocheAlquiler) vehiculo).tieneEquipamiento(elemento)) {
					((CocheAlquiler) vehiculo).mostrarDatos();
					enc = true;
				}
			}
		}

		if (!enc)
			System.out.println("No hay coches con ese equipamiento");
	}

	private static void calcularPresupuesto(ArrayList<Vehiculo> vehiculos) {
		Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculos);

		if (vehiculo != null) {
			int dias = 0;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					do {
						System.out.print("Introduce el numero de dias de alquiler: ");
						dias = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
						if (dias <= 0)
							System.out.println("El numero de dias debe ser mayor que 0");
					} while (dias <= 0);
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir numeros");
				}
			}

			double total = 0;
			if (vehiculo instanceof CocheAlquiler) {
				total = ((CocheAlquiler) vehiculo).calcularPresupuesto(dias);
			} else if (vehiculo instanceof FurgaAlquiler) {
				total = ((FurgaAlquiler) vehiculo).calcularPresupuesto(dias);
			}

			System.out.println("Presupuesto total para " + dias + " dias: " + total);
		}
	}

	private static void vehiculoPremium(ArrayList<Vehiculo> vehiculos) {
		if (vehiculos.size() == 0) {
			System.out.println("No hay vehiculos registrados");
			return;
		}

		Vehiculo masCaro = vehiculos.get(0);
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getPrecioBaseDia() > masCaro.getPrecioBaseDia()) {
				masCaro = vehiculo;
			}
		}

		System.out.println("=== Vehiculo mas caro ===");
		masCaro.mostrarDatos();
	}

}