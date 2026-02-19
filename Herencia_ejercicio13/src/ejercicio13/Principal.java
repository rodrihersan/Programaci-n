package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Comercio> comercios = new ArrayList<Comercio>();

		boolean salir = false;
		do {
			System.out.println("=== ASOCIACIÓN DE COMERCIANTES ===");
			System.out.println("1. Registrar Establecimiento");
			System.out.println("2. Añadir Producto a Supermercado");
			System.out.println("3. Añadir Plato a Restaurante");
			System.out.println("4. Venta de Productos (Supermercado)");
			System.out.println("5. Consultar Inventario de Supermercado");
			System.out.println("6. Análisis de Precios (Restaurante)");
			System.out.println("7. Salir");
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
				System.out.println("=== Registrar Establecimiento ===");
				registrarComercio(comercios);
				break;
			case 2:
				System.out.println("=== Añadir Producto a Supermercado ===");
				añadirProducto(comercios);
				break;
			case 3:
				System.out.println("=== Añadir Plato a Restaurante ===");
				añadirPlato(comercios);
				break;
			case 4:
				System.out.println("=== Venta de Productos ===");
				venderProducto(comercios);
				break;
			case 5:
				System.out.println("=== Consultar Inventario de Supermercado ===");
				consultarInventario(comercios);
				break;
			case 6:
				System.out.println("=== Análisis de Precios (Restaurante) ===");
				analizarPrecios(comercios);
				break;
			case 7:
				salir = true;
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void registrarComercio(ArrayList<Comercio> comercios) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoComercio = "";
		do {
			try {
				System.out.print("Introduce el tipo de establecimiento (Supermercado o Restaurante): ");
				tipoComercio = leer.readLine();

				if (!tipoComercio.equalsIgnoreCase("supermercado") && !tipoComercio.equalsIgnoreCase("restaurante")) {
					System.out.println("El tipo de establecimiento no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoComercio.equalsIgnoreCase("supermercado") && !tipoComercio.equalsIgnoreCase("restaurante"));

		int id = 1;
		if (comercios.size() > 0)
			id = comercios.getLast().getId() + 1;

		if (tipoComercio.equalsIgnoreCase("supermercado")) {
			Supermercado supermercado = new Supermercado();
			supermercado.pedirDatos(id);
			comercios.add(supermercado);
		} else {
			Restaurante restaurante = new Restaurante();
			restaurante.pedirDatos(id);
			comercios.add(restaurante);
		}

		System.out.println("Establecimiento registrado correctamente con ID: " + id);
	}

	private static Comercio buscarComercioPorId(ArrayList<Comercio> comercios) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idComercio = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el ID del establecimiento: ");
				idComercio = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		for (Comercio comercio : comercios) {
			if (comercio.getId() == idComercio) {
				return comercio;
			}
		}

		System.out.println("No se ha encontrado el establecimiento");
		return null;
	}

	private static void añadirProducto(ArrayList<Comercio> comercios) {
		Comercio comercio = buscarComercioPorId(comercios);

		if (comercio != null) {
			if (comercio instanceof Supermercado) {
				if (((Supermercado) comercio).añadirProducto() == true) {
					System.out.println("Producto añadido correctamente");
				} else {
					System.out.println("No se pueden añadir más productos, inventario lleno");
				}
			} else {
				System.out.println("El establecimiento no es un supermercado");
			}
		}
	}

	private static void añadirPlato(ArrayList<Comercio> comercios) {
		Comercio comercio = buscarComercioPorId(comercios);

		if (comercio != null) {
			if (comercio instanceof Restaurante) {
				if (((Restaurante) comercio).añadirPlato() == true) {
					System.out.println("Plato añadido correctamente");
				} else {
					System.out.println("No se pueden añadir más platos, carta llena");
				}
			} else {
				System.out.println("El establecimiento no es un restaurante");
			}
		}
	}

	private static void venderProducto(ArrayList<Comercio> comercios) {
		Comercio comercio = buscarComercioPorId(comercios);

		if (comercio != null) {
			if (comercio instanceof Supermercado) {
				((Supermercado) comercio).venderProducto();
			} else {
				System.out.println("El establecimiento no es un supermercado");
			}
		}
	}

	private static void consultarInventario(ArrayList<Comercio> comercios) {
		Comercio comercio = buscarComercioPorId(comercios);

		if (comercio != null) {
			if (comercio instanceof Supermercado) {
				((Supermercado) comercio).mostrarInventario();
			} else {
				System.out.println("El establecimiento no es un supermercado");
			}
		}
	}

	private static void analizarPrecios(ArrayList<Comercio> comercios) {
		Comercio comercio = buscarComercioPorId(comercios);

		if (comercio != null) {
			if (comercio instanceof Restaurante) {
				double ticketMedio = ((Restaurante) comercio).calcularTicketMedio();
				if (ticketMedio == 0) {
					System.out.println("El restaurante no tiene platos registrados");
				} else {
					System.out.printf("Ticket medio de la carta: ", ticketMedio);
				}
			} else {
				System.out.println("El establecimiento no es un restaurante");
			}
		}
	}

}