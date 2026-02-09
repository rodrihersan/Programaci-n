package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacienteUrgencias extends Paciente {
	private int gravedad;
	private String[] tratamientos = new String[5];
	private int numTratamientos;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {

			try {
				do {

					System.out.print("Introduce la gravedad (1-5): ");
					this.gravedad = Integer.parseInt(leer.readLine());
					if (gravedad < 1 || gravedad > 5)
						System.out.println("La gravedad solo puuede ser entre 1 y 5");
				} while (gravedad < 1 || gravedad > 5);

				numTratamientos = 0;
				datosOk = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);

	}

	public boolean añadirTratamiento() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numTratamientos < 5) {
			boolean datosOK = false;
			while (!datosOK) {
				try {
					System.out.println("Introduce el tratamiento " + this.numTratamientos);
					tratamientos[numTratamientos] = leer.readLine();
					numTratamientos++;
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void mostrarDatos() {
		super.mostrarDatos();

		System.out.println("Gravedad: " + this.gravedad);
		
		for(String tratamiento: tratamientos) {
			System.out.print(tratamiento + " ");
		}
		
		System.out.println("");
		System.out.println("----------------------------");
			

	}
}