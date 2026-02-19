package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EstudianteFP extends Estudiante {
	private String grado;
	private double[] notas = new double[8];
	private int numNotas;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el grado de FP: ");
				this.grado = leer.readLine();

				numNotas = 0;
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean añadirNota() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numNotas < 8) {
			boolean datosOK = false;
			while (!datosOK) {
				try {
					System.out.print("Introduce la nota de la asignatura " + (numNotas + 1) + " (0-10): ");
					double nota = Double.parseDouble(leer.readLine());

					if (nota < 0 || nota > 10) {
						System.out.println("La nota debe estar entre 0 y 10");
					} else {
						notas[numNotas] = nota;
						numNotas++;
						datosOK = true;
					}
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public double calcularMedia() {
		if (numNotas == 0)
			return 0;

		double suma = 0;
		for (int i = 0; i < numNotas; i++) {
			suma += notas[i];
		}
		return suma / numNotas;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: FP");
		System.out.println("Grado: " + this.grado);
		System.out.println("Notas: ");
		for (int i = 0; i < numNotas; i++) {
			System.out.println("  Asignatura " + (i + 1) + ": " + notas[i]);
		}
		System.out.printf("Media: %.2f%n", calcularMedia());
		System.out.println("----------------------------");
	}

}

