package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CocheAlquiler extends Vehiculo {
	private String categoria;
	private String[] equipamiento = new String[10];
	private int numEquipamiento;

	public void pedirDatos(ArrayList<Vehiculo> vehiculos) {
		super.pedirDatos(vehiculos);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOk = false;
		do {
			try {
				do {
					System.out.print("Introduce la categoria (economico, estandar o lujo): ");
					this.categoria = leer.readLine();
					if (!categoria.equalsIgnoreCase("economico") && !categoria.equalsIgnoreCase("estandar") && !categoria.equalsIgnoreCase("lujo"))
						System.out.println("La categoria debe ser economico, estandar o lujo");
				} while (!categoria.equalsIgnoreCase("economico") && !categoria.equalsIgnoreCase("estandar") && !categoria.equalsIgnoreCase("lujo"));

				numEquipamiento = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirEquipamiento() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numEquipamiento >= 10) {
			System.out.println("No se puede añadir mas equipamiento, limite de 10 alcanzado");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el equipamiento a añadir: ");
				equipamiento[numEquipamiento] = leer.readLine();
				numEquipamiento++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean tieneEquipamiento(String elemento) {
		for (int i = 0; i < numEquipamiento; i++) {
			if (equipamiento[i].equalsIgnoreCase(elemento)) {
				return true;
			}
		}
		return false;
	}

	public double calcularPresupuesto(int dias) {
		double total = dias * getPrecioBaseDia();
		if (categoria.equalsIgnoreCase("lujo")) {
			total += dias * 20;
		}
		return total;
	}

	public String getCategoria() {
		return categoria;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Coche de alquiler");
		System.out.println("Categoria: " + this.categoria);
		System.out.println("Equipamiento: ");
		for (int i = 0; i < numEquipamiento; i++) {
			System.out.println("  - " + equipamiento[i]);
		}
		System.out.println("----------------------------");
	}

}