package ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ordenador extends Dispositivo {
	private String procesador;
	private String ram;
	private String almacenamiento;
	private String[] componentes = new String[10];
	private int numComponentes;

	public void pedirDatos(ArrayList<Dispositivo> dispositivos) {
		super.pedirDatos(dispositivos);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el procesador: ");
				this.procesador = leer.readLine();

				System.out.print("Introduce la memoria RAM: ");
				this.ram = leer.readLine();

				System.out.print("Introduce el almacenamiento: ");
				this.almacenamiento = leer.readLine();

				numComponentes = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirComponente() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numComponentes >= 10) {
			System.out.println("No se pueden añadir mas componentes, limite de 10 alcanzado");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el componente a añadir: ");
				componentes[numComponentes] = leer.readLine();
				numComponentes++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean tieneComponente(String componente) {
		for (int i = 0; i < numComponentes; i++) {
			if (componentes[i].equalsIgnoreCase(componente)) {
				return true;
			}
		}
		return false;
	}

	public double calcularGarantiaExtendida() {
		return super.calcularGarantiaExtendida() + (getMesesGarantia() * 2);
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Ordenador");
		System.out.println("Procesador: " + this.procesador);
		System.out.println("RAM: " + this.ram);
		System.out.println("Almacenamiento: " + this.almacenamiento);
		System.out.println("Componentes: ");
		for (int i = 0; i < numComponentes; i++) {
			System.out.println("  - " + componentes[i]);
		}
		System.out.println("----------------------------");
	}

}