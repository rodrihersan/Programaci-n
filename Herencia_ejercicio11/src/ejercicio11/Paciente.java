package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paciente {
	private int id;
	private String nombre;
	private int edad;
	private long telefono;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOk = false;

		do {

			try {
				System.out.print("Introduce el nombre del paciente " + this.id + ":");
				this.nombre = leer.readLine();

				System.out.print("Introduce la edad: ");
				this.edad = Integer.parseInt(leer.readLine());

				System.out.print("Introduce el telefono: ");
				this.telefono = Long.parseLong(leer.readLine());

				datosOk = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);

	}

	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre paciente " + this.nombre);
		System.out.println("Edad paciente " + this.edad);
		System.out.println("Telefono paciente " + this.telefono);
	}
	
	public int getId() {
		return id;
	}
	
	
	
	
}