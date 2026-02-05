package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trabajador {
	private String nombre;
	private int id;
	private double salario;
	private String departamento;
	
	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		
		System.out.println("Introduce el nombre: ");
		this.nombre = leer.readLine();
		
		System.out.println("Introduce el departamento: ");
		this.departamento = leer.readLine();
		
		System.out.println("Introduce salario: ");
		this.salario = Double.parseDouble(leer.readLine());
	}
	
	public int getId() {
		return id;
	}
}
