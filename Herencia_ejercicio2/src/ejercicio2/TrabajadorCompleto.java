package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrabajadorCompleto extends Trabajador {
	private int antiguedad;
	
	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);
		
		System.out.println("Introduce salario: ");
		this.antiguedad = Integer.parseInt(leer.readLine());
	}

}
