package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Restaurante extends Comercio {
	private String[] platos = new String[30];
	private double[] precios = new double[30];
	private int numPlatos;

	public void pedirDatos(int id) {
		super.pedirDatos(id);
		numPlatos = 0;
	}

	public boolean añadirPlato() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numPlatos < 30) {
			boolean datosOK = false;
			while (!datosOK) {
				try {
					System.out.print("Introduce el nombre del plato: ");
					platos[numPlatos] = leer.readLine();

					System.out.print("Introduce el precio del plato: ");
					precios[numPlatos] = Double.parseDouble(leer.readLine());

					numPlatos++;
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

	public double calcularTicketMedio() {
		if (numPlatos == 0)
			return 0;

		double suma = 0;
		for (int i = 0; i < numPlatos; i++) {
			suma += precios[i];
		}
		return suma / numPlatos;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Restaurante");
		System.out.println("----------------------------");
	}
}