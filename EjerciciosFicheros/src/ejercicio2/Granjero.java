package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Granjero {
	private String nombre;
	private int tipo;
	private double metros;
	
	public void pedirDatos() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean todoOk = false;

		do {
			try {
				System.out.println("Introduce nombre: ");
				this.nombre = leer.readLine();
				do {
				    System.out.println("Introduce el tipo de fumigacion (1-4): ");
				    System.out.println(" malas hierbas");
				    System.out.println("Fumigación contra langostas");
				    System.out.println("Fumigación contra gusanos");
				    System.out.println("Fumigación contra todo lo anterior");
				    this.tipo = Integer.parseInt(leer.readLine());
				} while (this.tipo < 1 || this.tipo > 4);
				
				do {
				System.out.println("Introduce cantidad de metros cuadrados que desea: ");
				this.metros = Double.parseDouble(leer.readLine());
				if(this.metros <= 0) {
					System.out.println("Para que quieres nuestros servicios si no tienes tierras");
				}
				} while (this.metros <= 0);
				todoOk = true;
				
			} catch (Exception e) {
				System.err.println("ERROR");
			}

		} while (!todoOk);

	}
	
	public void escribirFichero() {
		try {
			File f = new File("./granjeros.txt");
			FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Nombre: " + nombre);
			pw.println("Tipo fumigaicon: " + tipo);
			pw.println("Metros: " + metros);
			
		} catch (IOException e) {
		System.err.println("ERROR");
	}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
