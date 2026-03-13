package examenFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Candidato {
	private int id;
	private String nombre;
	private String partido;
	private int votos;
	
	public void pedirCandidato() throws IOException {
		do {
			this.id = Lecturas.leerEntero("Introduce el id del candidato: ");
			if(this.id <= 0) {
				System.err.println("Tiene que ser un numero mayor que cero. ");
			}
		} while (this.id <= 0 );

		this.nombre = Lecturas.leerString("Introduce el nombre del candidato: ");
		this.partido = Lecturas.leerOpcion("Introduce el partido político (AJE / PJS / PCD / MIAF): ", new String[] {"AJE", "PJS", "PCD", "MIAF"});

		do {
			this.votos = Lecturas.leerEntero("Introduce el número de votos obtenidos: ");
			if(this.votos < 0) {
				System.err.println("Tiene que ser un numero igual o mayor que cero. ");
			}
		} while (votos < 0);
		
		System.out.println("Datos introducidos correctamente");
	}
	
	public void escribirFichero(File f, boolean añadir) throws IOException {
		FileWriter fw = new FileWriter(f, añadir);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(this.id + "-" + this.nombre + "-" + this.partido + "-" + this.votos);

		pw.flush();
		pw.close();
		fw.close();
	}
	
	public void leerCandidato(String linea) throws IOException {
		String[] datos = linea.split("-");

		this.id = Integer.parseInt(datos[0].trim());
		this.nombre = datos[1].trim();
		this.partido = datos[2].trim();
		this.votos = Integer.parseInt(datos[3].trim());
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPartido() {
		return partido;
	}

	public int getVotos() {
		return votos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	
}
