package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Supermercado extends Comercio {
	private String[] productos = new String[50];
	private int[] stocks = new int[50];
	private int numProductos;

	public void pedirDatos(int id) {
		super.pedirDatos(id);
		numProductos = 0;
	}

	public boolean añadirProducto() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numProductos < 50) {
			boolean datosOK = false;
			while (!datosOK) {
				try {
					System.out.print("Introduce el nombre del producto: ");
					productos[numProductos] = leer.readLine();

					System.out.print("Introduce el stock inicial: ");
					stocks[numProductos] = Integer.parseInt(leer.readLine());

					numProductos++;
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Ha habido un error con los datos");
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean venderProducto() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Introduce el nombre del producto a vender: ");
		String nombreProducto = "";
		try {
			nombreProducto = leer.readLine();
		} catch (IOException e) {
			System.err.println("Error leyendo el nombre");
			return false;
		}

		int posicion = -1;
		for (int i = 0; i < numProductos; i++) {
			if (productos[i].equalsIgnoreCase(nombreProducto)) {
				posicion = i;
				break;
			}
		}

		if (posicion == -1) {
			System.out.println("Producto no encontrado");
			return false;
		}

		System.out.println("Stock actual de " + productos[posicion] + ": " + stocks[posicion]);

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce la cantidad a vender: ");
				int cantidad = Integer.parseInt(leer.readLine());

				if (cantidad > stocks[posicion]) {
					System.out.println("No hay suficiente stock. Stock disponible: " + stocks[posicion]);
				} else if (cantidad <= 0) {
					System.out.println("La cantidad debe ser mayor que 0");
				} else {
					stocks[posicion] -= cantidad;
					System.out.println("Venta realizada. Nuevo stock de " + productos[posicion] + ": " + stocks[posicion]);
					datosOK = true;
				}
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}
		return true;
	}

	public void mostrarInventario() {
		super.mostrarDatos();
		System.out.println("--- Inventario ---");
		if (numProductos == 0) {
			System.out.println("No hay productos registrados");
		} else {
			for (int i = 0; i < numProductos; i++) {
				System.out.println("  Producto: " + productos[i] + " | Stock: " + stocks[i]);
			}
		}
		System.out.println("----------------------------");
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Supermercado");
		System.out.println("----------------------------");
	}
}