package ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PedidoNacional extends Pedido {
	private String provincia;
	private String[] nombresProductos = new String[20];
	private int[] cantidades = new int[20];
	private double[] precios = new double[20];
	private int numProductos;

	public void pedirDatos(ArrayList<Pedido> pedidos) {
		super.pedirDatos(pedidos);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce la provincia de destino: ");
				this.provincia = leer.readLine();

				numProductos = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirProducto() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numProductos >= 20) {
			System.out.println("No se pueden añadir mas productos, limite de 20 alcanzado");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre del producto: ");
				nombresProductos[numProductos] = leer.readLine();

				boolean cantidadOk = false;
				while (!cantidadOk) {
					try {
						System.out.print("Introduce la cantidad: ");
						cantidades[numProductos] = Integer.parseInt(leer.readLine());
						cantidadOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				boolean precioOk = false;
				while (!precioOk) {
					try {
						System.out.print("Introduce el precio unitario: ");
						precios[numProductos] = Double.parseDouble(leer.readLine());
						precioOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				numProductos++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean tieneProducto(String nombre) {
		for (int i = 0; i < numProductos; i++) {
			if (nombresProductos[i].equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	public double calcularSubtotal() {
		double subtotal = 0;
		for (int i = 0; i < numProductos; i++) {
			subtotal += cantidades[i] * precios[i];
		}
		return subtotal;
	}

	public double calcularTotal() {
		return calcularSubtotal() + 5;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Nacional");
		System.out.println("Provincia: " + this.provincia);
		System.out.println("Productos: ");
		for (int i = 0; i < numProductos; i++) {
			System.out.println("  - " + nombresProductos[i] + " | Cantidad: " + cantidades[i] + " | Precio: " + precios[i]);
		}
		System.out.println("----------------------------");
	}

}