package ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {
	private int numeroPedido;
	private String nombreCliente;
	private String fecha;
	private String estado;

	public void pedirDatos(ArrayList<Pedido> pedidos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		Random rand = new Random();
		int numeroGenerado = -1;
		do {
			numeroGenerado = rand.nextInt(1000) + 1;
		} while (numeroRepetido(pedidos, numeroGenerado));
		this.numeroPedido = numeroGenerado;
		System.out.println("Numero de pedido asignado: " + this.numeroPedido);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el nombre del cliente: ");
				this.nombreCliente = leer.readLine();

				System.out.print("Introduce la fecha del pedido: ");
				this.fecha = leer.readLine();

				do {
					System.out.print("Introduce el estado (pendiente, procesado o enviado): ");
					this.estado = leer.readLine();
					if (!estado.equalsIgnoreCase("pendiente") && !estado.equalsIgnoreCase("procesado") && !estado.equalsIgnoreCase("enviado"))
						System.out.println("El estado solo puede ser pendiente, procesado o enviado");
				} while (!estado.equalsIgnoreCase("pendiente") && !estado.equalsIgnoreCase("procesado") && !estado.equalsIgnoreCase("enviado"));

				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	private boolean numeroRepetido(ArrayList<Pedido> pedidos, int numeroGenerado) {
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getNumeroPedido() == numeroGenerado) {
				return true;
			}
		}
		return false;
	}

	public boolean actualizarEstado() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String nuevoEstado = "";

		do {
			try {
				System.out.print("Introduce el nuevo estado (pendiente, procesado o enviado): ");
				nuevoEstado = leer.readLine();
				if (!nuevoEstado.equalsIgnoreCase("pendiente") && !nuevoEstado.equalsIgnoreCase("procesado") && !nuevoEstado.equalsIgnoreCase("enviado"))
					System.out.println("El estado solo puede ser pendiente, procesado o enviado");
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!nuevoEstado.equalsIgnoreCase("pendiente") && !nuevoEstado.equalsIgnoreCase("procesado") && !nuevoEstado.equalsIgnoreCase("enviado"));

		this.estado = nuevoEstado;
		return true;
	}

	public double calcularSubtotal() {
		return 0;
	}

	public double calcularTotal() {
		return 0;
	}

	public void mostrarDatos() {
		System.out.println("Numero de pedido: " + this.numeroPedido);
		System.out.println("Cliente: " + this.nombreCliente);
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Estado: " + this.estado);
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

}