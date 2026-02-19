package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FurgaAlquiler extends Vehiculo {
	private double capacidadCarga;
	private String[] extras = new String[8];
	private int numExtras;

	public void pedirDatos(ArrayList<Vehiculo> vehiculos) {
		super.pedirDatos(vehiculos);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOk = false;
		do {
			try {
				boolean capacidadOk = false;
				while (!capacidadOk) {
					try {
						System.out.print("Introduce la capacidad de carga (m3): ");
						this.capacidadCarga = Double.parseDouble(leer.readLine());
						capacidadOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				numExtras = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirExtra() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numExtras >= 8) {
			System.out.println("No se puede añadir mas extras, limite de 8 alcanzado");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el extra a añadir: ");
				extras[numExtras] = leer.readLine();
				numExtras++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public double calcularPresupuesto(int dias) {
		return dias * getPrecioBaseDia();
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Furgoneta de alquiler");
		System.out.println("Capacidad de carga: " + this.capacidadCarga + " m3");
		System.out.println("Extras: ");
		for (int i = 0; i < numExtras; i++) {
			System.out.println("  - " + extras[i]);
		}
		System.out.println("----------------------------");
	}

}