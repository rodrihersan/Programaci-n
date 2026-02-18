package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tenista extends Deportista {
	private int posicionRanking;
	private ArrayList<String> historialTorneos = new ArrayList<>();

	public void pedirDatos(ArrayList<Deportista> deportistas) {
		super.pedirDatos(deportistas);
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOK = false;
		while (!datosOK) {

			try {

				do {
					System.out.print("Introduce la posicion del ranking: ");
					posicionRanking = Integer.parseInt(leer.readLine());
					if (posicionRanking < 0)
						System.out.println("La edad no puede ser negativa");
				} while (posicionRanking < 0);

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
	}
	
	public void añadirTorneo() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if(historialTorneos.size() < 10) {
			boolean datosOK = false;
			while(!datosOK) {
				try {
					System.out.println("Introduce el torneo: ");
					historialTorneos.add(leer.readLine());
					datosOK = true;
				}catch(IOException e) {
					System.out.println("Has introducido mal algún dato, crack");
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("No se puede guardar mas torneos por llegar al máximo de 10.");
		}
	}
	
	public void mostrarDatos() {
		System.out.println("posicion en el ranking: " + this.posicionRanking);
		System.out.println("Historial de torneos: ");
		for(String torneo : historialTorneos) {
			System.out.println(torneo + " , ");
		}
	}
	
}