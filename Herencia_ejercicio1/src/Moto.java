//clase hija de padre

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moto extends Vehiculo{
	private int cilindrada;
	
	
	
	public void pedirDatos(int id) throws IOException 	 {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);
		System.out.println("Introduce la cilindrada: ");
		cilindrada = Integer.parseInt(leer.readLine());
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Cilindrada: " + cilindrada);
	}
}