package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrabajadorCompleto extends Trabajador{
	private int antiguedad;
	
	
	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);
		
		boolean datosOK = false;
		while (!datosOK) {

			try {
				
				do {
					System.out.println("Introduce la antiguedad: ");
					this.antiguedad = Integer.parseInt(leer.readLine());
					if (this.antiguedad < 0)
						System.out.println("El salario tienen que ser positivos");
				} while (this.antiguedad < 0);
				

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
		
	}
	
	public double salario() {
		return super.getSalario() + (this.antiguedad * 100);
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Salario: " + salario());
		System.out.println("Antiguedad: " + this.antiguedad);
	}
}