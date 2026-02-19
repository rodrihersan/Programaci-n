package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Evento {
	private int id;
	private String nombre;
	private String fecha;
	private String lugar;
	private int capacidadMaxima;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOk = false;

		do {
			try {
				System.out.print("Introduce el nombre del evento: ");
				this.nombre = leer.readLine();

				System.out.print("Introduce la fecha del evento: ");
				this.fecha = leer.readLine();

				System.out.print("Introduce el lugar de celebración: ");
				this.lugar = leer.readLine();

				boolean capacidadOk = false;
				while (!capacidadOk) {
					try {
						System.out.print("Introduce la capacidad máxima: ");
						this.capacidadMaxima = Integer.parseInt(leer.readLine());
						capacidadOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir números");
					}
				}

				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Lugar: " + this.lugar);
		System.out.println("Capacidad máxima: " + this.capacidadMaxima);
	}

	public int getId() {
		return id;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public int getNumAsistentes() {
		return 0;
	}

}