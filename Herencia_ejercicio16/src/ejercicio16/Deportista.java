package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Deportista extends Persona{
	private String deporte;
	private String categoria;
	
	
	protected void pedirDatos(ArrayList<Deportista> deportistas) {
		super.pedirDatos(deportistas);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce el deporte: ");
				deporte = leer.readLine();
				
			
				do {
					System.out.print("Introduce la categoría (amateur-profesional): ");
					categoria = leer.readLine();
					if (!categoria.equalsIgnoreCase("amateur") && !categoria.equalsIgnoreCase("profesional"))
						System.out.println("Tienes que introducir un tipo valido");
				} while (!categoria.equalsIgnoreCase("amateur") && !categoria.equalsIgnoreCase("profesional"));


				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}
		}
	}
	
	protected void mostrarDatos() {
		System.out.println("deporte: " + this.deporte);
		System.out.println("categoria: " + this.categoria);
	}
}
