package Recuperacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ViajeInternacional extends Viaje {
	private String pais;
	private boolean visado;
	
	public void pedirDatos(ArrayList<Viaje> viajes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        super.pedirDatos(viajes);
        
        System.out.println("--- DATOS INTERNACIONALES ---");
        this.pais = Lecturas.leerString("Introduce el país: ");
        
        char char_visado;
        do {
        System.out.println("Introduce si necesita visado (S/N): ");
        char_visado = leer.readLine().toUpperCase().charAt(0);
		if (char_visado != 'S' && char_visado != 'N')
			System.out.println("Solo puede ser S o N");
		else {
			if(char_visado == 'S')
				visado = true;
			else
				visado = false;
			}
		} while (char_visado != 'S' &&char_visado != 'N');
        System.out.println("Propuesta registrada correctamente");
    }
	
	public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("País: " + this.pais);
        System.out.println("Visado: " + this.visado);
    }
	
	public boolean visado() {
		return visado;
	}
}