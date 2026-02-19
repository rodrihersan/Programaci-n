package oscar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1: Nombres significativos
El nombre "Principal" indica que es el punto de entrada del programa.
Las variables como "vehiculos", "salir", "opcion" describen lo que va a hacer cada uno.
Los beneficios son su fácil comprensión 
*/

public class Principal {

	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		/*
		 * 2: Responsabilidad Única (SRP) La clase Principal solo gestiona el menú y la
		 * interacción con el usuario. La lógica del vehículo está en la clase Vehiculo.
		 * Los beneficios son que cada clase tiene una única responsabilidad y no se
		 * mezclan entre ellas.
		 */
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		vehiculos.add(new Vehiculo(1, "coche", "Toyota", 40));
		vehiculos.add(new Vehiculo(2, "moto", "Yamaha", 25));
		vehiculos.add(new Vehiculo(3, "bicicleta", "BH", 10));

		boolean salir = false;

		do {
			System.out.println("\n=== ALQUILER DE VEHÍCULOS ===");
			System.out.println("1. Ver vehículos disponibles");
			System.out.println("2. Alquilar vehículo");
			System.out.println("3. Devolver vehículo");
			System.out.println("4. Salir");
			System.out.print("Opción: ");

			int opcion = Integer.parseInt(leer.readLine());

			switch (opcion) {

			case 1:
				registrarVehiculo(vehiculos);
				break;

			case 2:
				mostrarDisponibles(vehiculos);
				break;

			case 3:
				alquilarVehiculo(vehiculos);
				break;

			case 4:
				devolverVehiculo(vehiculos);
				break;

			case 5:
				salir = true;
				break;

			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);

	}

	/*
	 * 3: Métodos pequeños Lo dividimos en métodos pequeños: registrarVehiculo,
	 * mostrarDisponibles, alquilarVehiculo, devolverVehiculo. Los beneficios son
	 * que mejora su lectura y el mantenimiento.
	 */

	private static void registrarVehiculo(ArrayList<Vehiculo> vehiculos) throws IOException {

		System.out.print("Introduce ID: ");
		int id = Integer.parseInt(leer.readLine());

		System.out.print("Introduce tipo (coche, moto, bicicleta): ");
		String tipo = leer.readLine();

		System.out.print("Introduce modelo: ");
		String modelo = leer.readLine();

		System.out.print("Introduce precio por dia: ");
		double precio = Double.parseDouble(leer.readLine());

		Vehiculo v = new Vehiculo(id, tipo, modelo, precio);
		vehiculos.add(v);

		System.out.println("Vehiculo registrado correctamente");
	}

	private static void mostrarDisponibles(ArrayList<Vehiculo> vehiculos) {

		/*
		 * 4: Nombres con sentido El beneficio es que no se usan códigos complejos ni
		 * dificiles de entender innecesarios
		 */

		boolean hay = false;

		for (Vehiculo v : vehiculos) {
			if (v.isDisponible()) {
				System.out.println(v.toString());
				hay = true;
			}
		}

		if (!hay) {
			System.out.println("No hay vehiculos disponibles");
		}
	}

	private static void alquilarVehiculo(ArrayList<Vehiculo> vehiculos) throws IOException {

		System.out.print("Introduce ID del vehiculo: ");
		int id = Integer.parseInt(leer.readLine());

		boolean encontrado = false;

		for (Vehiculo v : vehiculos) {

			/*
			 * 5: Bajo acoplamiento Principal no modifica directamente los atributos del
			 * objeto. Los beneficios son la facilidad del mantenimiento, reutilización del
			 * código, escalabilidad y pruebas más efectivas
			 */

			if (v.getId() == id) {
				encontrado = true;

				if (v.isDisponible()) {

					System.out.print("Nombre del cliente: ");
					String cliente = leer.readLine();

					System.out.print("Dias de alquiler: ");
					int dias = Integer.parseInt(leer.readLine());

					v.alquilar(cliente, dias);
				} else {
					System.out.println("No disponible");
				}
			}
		}

		if (!encontrado) {
			System.out.println("Vehiculo no encontrado");
		}
	}

	private static void devolverVehiculo(ArrayList<Vehiculo> vehiculos) throws IOException {

		System.out.print("Introduce ID: ");
		int id = Integer.parseInt(leer.readLine());

		for (Vehiculo v : vehiculos) {
			if (v.getId() == id) {
				v.devolver();
			}
		}
	}
}