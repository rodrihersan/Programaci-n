package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrabajadorTemporal extends Trabajador{
	private int mesesContrato;
	
	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);
		
		boolean datosOK = false;
		while (!datosOK) {

			try {
				
				do {
					System.out.println("Introduce los meses de contrato: ");
					this.mesesContrato = Integer.parseInt(leer.readLine());
					if (this.mesesContrato < 0)
						System.out.println("El salario tienen que ser positivos");
				} while (this.mesesContrato < 0);
				

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
		
	}
	
	public double salario() {
		return super.getSalario();
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Salario: " + salario());
		System.out.print("Mese de contrato: " + this.mesesContrato);
	}

}