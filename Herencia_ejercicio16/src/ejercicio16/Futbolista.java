package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Futbolista extends Deportista{
	private String posicion;
	private int numGoles;
	private String equipo;
	
	
	public void pedirDatos(ArrayList<Deportista> deportistas) {
		super.pedirDatos(deportistas);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce la posicion del jugador: ");
				posicion = leer.readLine();
				
				do {
					System.out.print("Introduce numero de goles: ");
					numGoles = Integer.parseInt(leer.readLine());
					if (numGoles < 0)
						System.out.println("La edad no puede ser negativa");
				} while (numGoles < 0);
				
				System.out.print("Introduce el equipo: ");
				equipo = leer.readLine();

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
	}
}
