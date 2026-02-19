package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comercio {
	private int id;
	private String nombre;
	private String direccion;
	private String propietario;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOk = false;

		do {
			try {
				System.out.print("Introduce el nombre del establecimiento: ");
				this.nombre = leer.readLine();

				System.out.print("Introduce la dirección física: ");
				this.direccion = leer.readLine();

				System.out.print("Introduce el nombre del propietario: ");
				this.propietario = leer.readLine();

				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre establecimiento: " + this.nombre);
		System.out.println("Dirección: " + this.direccion);
		System.out.println("Propietario: " + this.propietario);
	}

	public int getId() {
		return id;
	}

}
