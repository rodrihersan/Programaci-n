package ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

		boolean salir = false;
		do {
			System.out.println("\n=== EMPRESA DE LOGISTICA ===");
			System.out.println("1. Crear Pedido");
			System.out.println("2. Añadir Producto a Pedido");
			System.out.println("3. Actualizar Estado");
			System.out.println("4. Calcular Facturacion");
			System.out.println("5. Buscador de Articulos");
			System.out.println("6. Pedido de Mayor Importe");
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
				System.out.println("=== Crear Pedido ===");
				crearPedido(pedidos);
				break;
			case 2:
				System.out.println("=== Añadir Producto a Pedido ===");
				añadirProducto(pedidos);
				break;
			case 3:
				System.out.println("=== Actualizar Estado ===");
				actualizarEstado(pedidos);
				break;
			case 4:
				System.out.println("=== Calcular Facturacion ===");
				calcularFacturacion(pedidos);
				break;
			case 5:
				System.out.println("=== Buscador de Articulos ===");
				buscarArticulo(pedidos);
				break;
			case 6:
				System.out.println("=== Pedido de Mayor Importe ===");
				pedidoMayorImporte(pedidos);
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

	private static void crearPedido(ArrayList<Pedido> pedidos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoPedido = "";
		do {
			try {
				System.out.print("Introduce el tipo de pedido (Nacional o Internacional): ");
				tipoPedido = leer.readLine();

				if (!tipoPedido.equalsIgnoreCase("nacional") && !tipoPedido.equalsIgnoreCase("internacional")) {
					System.out.println("El tipo de pedido no es correcto");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!tipoPedido.equalsIgnoreCase("nacional") && !tipoPedido.equalsIgnoreCase("internacional"));

		if (tipoPedido.equalsIgnoreCase("nacional")) {
			PedidoNacional pedido = new PedidoNacional();
			pedido.pedirDatos(pedidos);
			pedidos.add(pedido);
		} else {
			PedidoInternacional pedido = new PedidoInternacional();
			pedido.pedirDatos(pedidos);
			pedidos.add(pedido);
		}

		System.out.println("Pedido creado correctamente");
	}

	private static Pedido buscarPedidoPorNumero(ArrayList<Pedido> pedidos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numeroPedido = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el numero de pedido: ");
				numeroPedido = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir numeros");
			}
		}

		for (Pedido pedido : pedidos) {
			if (pedido.getNumeroPedido() == numeroPedido) {
				return pedido;
			}
		}

		System.out.println("No se ha encontrado el pedido");
		return null;
	}

	private static void añadirProducto(ArrayList<Pedido> pedidos) {
		Pedido pedido = buscarPedidoPorNumero(pedidos);

		if (pedido != null) {
			if (pedido instanceof PedidoNacional) {
				if (((PedidoNacional) pedido).añadirProducto()) {
					System.out.println("Producto añadido correctamente");
				}
			} else if (pedido instanceof PedidoInternacional) {
				if (((PedidoInternacional) pedido).añadirProducto()) {
					System.out.println("Producto añadido correctamente");
				}
			}
		}
	}

	private static void actualizarEstado(ArrayList<Pedido> pedidos) {
		Pedido pedido = buscarPedidoPorNumero(pedidos);

		if (pedido != null) {
			if (pedido.actualizarEstado()) {
				System.out.println("Estado actualizado correctamente");
			}
		}
	}

	private static void calcularFacturacion(ArrayList<Pedido> pedidos) {
		Pedido pedido = buscarPedidoPorNumero(pedidos);

		if (pedido != null) {
			if (pedido instanceof PedidoNacional) {
				System.out.println("Subtotal: " + ((PedidoNacional) pedido).calcularSubtotal());
				System.out.println("Total (con envio 5): " + ((PedidoNacional) pedido).calcularTotal());
			} else if (pedido instanceof PedidoInternacional) {
				System.out.println("Subtotal: " + ((PedidoInternacional) pedido).calcularSubtotal());
				System.out.println("Total (con envio 20 + aduana): " + ((PedidoInternacional) pedido).calcularTotal());
			}
		}
	}

	private static void buscarArticulo(ArrayList<Pedido> pedidos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";

		try {
			System.out.print("Introduce el nombre del producto a buscar: ");
			nombre = leer.readLine();
		} catch (IOException e) {
			System.err.println("Ha habido un error");
			return;
		}

		boolean enc = false;
		for (Pedido pedido : pedidos) {
			if (pedido instanceof PedidoNacional) {
				if (((PedidoNacional) pedido).tieneProducto(nombre)) {
					pedido.mostrarDatos();
					enc = true;
				}
			} else if (pedido instanceof PedidoInternacional) {
				if (((PedidoInternacional) pedido).tieneProducto(nombre)) {
					pedido.mostrarDatos();
					enc = true;
				}
			}
		}

		if (!enc)
			System.out.println("No hay pedidos con ese producto");
	}

	private static void pedidoMayorImporte(ArrayList<Pedido> pedidos) {
		if (pedidos.size() == 0) {
			System.out.println("No hay pedidos registrados");
			return;
		}

		Pedido mayorImporte = pedidos.get(0);
		for (Pedido pedido : pedidos) {
			if (pedido.calcularTotal() > mayorImporte.calcularTotal()) {
				mayorImporte = pedido;
			}
		}

		System.out.println("=== Pedido de mayor importe ===");
		mayorImporte.mostrarDatos();
		System.out.println("Total: " + mayorImporte.calcularTotal());
	}

}