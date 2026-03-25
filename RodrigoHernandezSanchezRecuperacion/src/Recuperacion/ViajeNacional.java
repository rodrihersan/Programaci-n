package Recuperacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ViajeNacional extends Viaje {
	private boolean alojamiento;
	private int numNoches;
	private String CCAA;
	
	public void pedirDatos(ArrayList<Viaje> viajes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(viajes);

		System.out.println("--- DATOS NACIONALES ---");
		boolean datosOk = false;
		do {
			try {
				this.CCAA = Lecturas.leerString("Introduce el nombre de la CCAA: ");
				
				char char_alojamiento;
		        do {
		        System.out.println("Introduce si necesita alojamiento (S/N): ");
		        char_alojamiento = leer.readLine().toUpperCase().charAt(0);
				if (char_alojamiento != 'S' &&char_alojamiento != 'N')
					System.out.println("Solo puede ser S o N");
				else {
					if(char_alojamiento == 'S')
						alojamiento = true;
					else
						alojamiento = false;
					}
				} while (char_alojamiento != 'S' &&char_alojamiento != 'N');
				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
        System.out.println("Propuesta registrada correctamente");

	}
	
	public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("CCAA: " + this.CCAA);
        System.out.println("Numero de noches: " + this.numNoches);
        System.out.println("Alojamiento: " + this.alojamiento);
    }
}