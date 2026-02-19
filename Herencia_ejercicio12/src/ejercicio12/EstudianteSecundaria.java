package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EstudianteSecundaria extends Estudiante {
	private String grupo;
	private double[] evaluaciones = new double[3];

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce el grupo (letra): ");
				this.grupo = leer.readLine();

				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	public boolean registrarEvaluacion() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		int numEval = 0;
		boolean datosOK = false;
		while (!datosOK) {
			try {
				do {
					System.out.print("Introduce la evaluación a registrar (1, 2 o 3): ");
					numEval = Integer.parseInt(leer.readLine());
					if (numEval < 1 || numEval > 3)
						System.out.println("Solo puedes introducir 1, 2 o 3");
				} while (numEval < 1 || numEval > 3);
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}

		datosOK = false;
		while (!datosOK) {
			try {
				System.out.print("Introduce la nota de la " + numEval + "ª evaluación (0-10): ");
				double nota = Double.parseDouble(leer.readLine());

				if (nota < 0 || nota > 10) {
					System.out.println("La nota debe estar entre 0 y 10");
				} else {
					evaluaciones[numEval - 1] = nota;
					datosOK = true;
				}
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir números");
			}
		}
		return true;
	}

	public double calcularMedia() {
		double suma = 0;
		for (int i = 0; i < 3; i++) {
			suma += evaluaciones[i];
		}
		return suma / 3;
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tipo: Secundaria");
		System.out.println("Grupo: " + this.grupo);
		System.out.println("1ª Evaluación: " + evaluaciones[0]);
		System.out.println("2ª Evaluación: " + evaluaciones[1]);
		System.out.println("3ª Evaluación: " + evaluaciones[2]);
		System.out.printf("Media: ", calcularMedia());
		System.out.println("----------------------------");
	}

}