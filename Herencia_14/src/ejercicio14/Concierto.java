package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Concierto extends Evento {
	private String artista;
	private String[] asistentes = new String[100];
	private int numAsistentes;
	private double precioEntrada;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el nombre del artista: ");
				this.artista = leer.readLine();

				boolean precioOk = false;
				while (!precioOk) {
					try {
						System.out.print("Introduce el precio de la entrada: ");
						this.precioEntrada = Double.parseDouble(leer.readLine());
						precioOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir números");
					}
				}

				numAsistentes = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirAsistente() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numAsistentes >= getCapacidadMaxima()) {
			System.out.println("Se ha alcanzado la capacidad máxima del recinto");
			return false;
		}

		if (numAsistentes >= 100) {
			System.out.println("Se ha alcanzado el límite de 100 registros");
			return false;
		}

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce el nombre del asistente: ");
				asistentes[numAsistentes] = leer.readLine();
				numAsistentes++;
				datosOK = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos");
			}
		}
		return true;
	}

	public boolean buscarAsistente(String nombre) {
		for (int i = 0; i < numAsistentes; i++) {
			if (asistentes[i].equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	public double calcularRecaudacion() {
		return numAsistentes * precioEntrada;
	}

	public int getNumAsistentes() {
		return numAsistentes;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Concierto");
		System.out.println("Artista: " + this.artista);
		System.out.println("Precio entrada: " + this.precioEntrada);
		System.out.println("Asistentes registrados: " + this.numAsistentes);
		System.out.println("----------------------------");
	}

}