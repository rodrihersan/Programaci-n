package ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Estudiante {
	private int id;
	private String nombre;
	private int edad;
	private String curso;
	
	
	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		boolean datosOk = false;

		do {

			try {
				System.out.print("Introduce el nombre del estudiante " + this.id + ":");
				this.nombre = leer.readLine();

				System.out.print("Introduce la edad: ");
				this.edad = Integer.parseInt(leer.readLine());
				
				do {
					System.out.print("Introduce el curso (FP o Secundaria): ");
					curso = leer.readLine();
					if (!curso.equalsIgnoreCase("Secundaria") && !curso.equalsIgnoreCase("FP"))
						System.out.println("Tienes que introducir un curso valido");
				} while (!curso.equalsIgnoreCase("Secundaria") && !curso.equalsIgnoreCase("FP")); 			


				datosOk = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);

	}
}
