package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trabajador {
	private int id;
	private String nombre;
	private double salario;
	private String departamento;
	
	
	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		
		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce el nombre del Trabajador: ");
				this.nombre = leer.readLine();
				
				do {
					System.out.println("Introduce el salario: ");
					this.salario = Double.parseDouble(leer.readLine());
					if (this.salario < 0)
						System.out.println("El salario tienen que ser positivos");
				} while (this.salario < 0);
				
				System.out.print("Introduce el nombre del departamento: ");
				this.departamento = leer.readLine();
				

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}

	}
	
	
	public void mostrarDatos() {
		System.out.println("===========================");
		System.out.println("EMPLEADO ID: " + this.id );
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Departamento: " + this.departamento);
	}

	public int getId() {
		return id;
	}

	public double getSalario() {
		return salario;
	}
	
	
	
	
	
	
}