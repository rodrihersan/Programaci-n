package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrabajadorTemporal extends Trabajador{
	private int mesesContrato;
	
	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);
		
		System.out.println("Introduce mesesContrato: ");
		this.mesesContrato = Integer.parseInt(leer.readLine());

}
}
