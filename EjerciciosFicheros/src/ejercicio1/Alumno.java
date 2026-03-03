package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Alumno {
	private int expediente;
	private String nombre;
	private double[] notas = new double[3];

	public void pedirDatos() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean todoOk = false;

		do {
			try {
				do {
					System.out.println("Introduce numero de expediente");
					this.expediente = Integer.parseInt(leer.readLine());
				} while (this.expediente < 0);

				System.out.println("Introduce el nombre del alumno: ");
				this.nombre = leer.readLine();

				for (int i = 0; i < notas.length; i++) {
					do {
						System.out.println("Introduce la nota " + (i + 1));
						notas[i] = Integer.parseInt(leer.readLine());
					} while (notas[i] < 0 || notas[i] > 10);
				}
				
				todoOk = true;

			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

		} while (!todoOk);

	}

	public void guardar(boolean añadir) {
		File f = new File("./alumnos.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, añadir);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("NUMERO DE EXPEDIENTE: " + this.expediente);
			pw.println("NOMBRE: "+ this.nombre);
			pw.println("NOTAS: ");
			for (int i = 0; i < notas.length; i++) {
				pw.println(notas[i]);
			}
			
			pw.flush();
			pw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public double calcularMedia() {
		double media = 0;
		
		for(int i = 0; i < 3; i++) {
			media = media + this.notas[i];
		}
		
		return (media/3);
	}
	
	
	

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	

}