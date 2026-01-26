package EjercicioOpcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Oferta {
	private int id;
	private String nombre;
	private int oferta;
	private boolean resort;
	private String respuesta;

	private BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public void añadirDatos(Oferta[] ofertas, int pos) {
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(1000) + 1;
		} while (estaRepetido(ofertas, pos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;

		boolean datosOK = false;
		while (!datosOK) {
			try {

				System.out.println("Escribe el nombre del postor");
				nombre = leer.readLine();

				System.out.println("Escribe la oferta");
				oferta = Integer.parseInt(leer.readLine());

				System.out.println("Incluye Resort?");
				char r = leer.readLine().toUpperCase().charAt(0);

				if (r == 'S') {
					resort = true;
				}

				System.out.println("Escribe al respuesta de Dinamarca");
				respuesta = leer.readLine();
				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}

	}
	
	private boolean estaRepetido(Oferta[] ofertas, int pos, int idGenerado) {
		for (int i = 0; i < (pos - 1); i++) {
			if (ofertas[i].getId() == idGenerado) {
				return true;
			}

		}
		return false;

	}
	
	public boolean esOfertaRidicula() {
		if(oferta < 100)
			return true;
		else
			return false;
	}

	public int getId() {
		return id;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOferta() {
		return oferta;
	}


	public boolean isResort() {
		return resort;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", nombre=" + nombre + ", oferta=" + oferta + ", resort=" + resort + ", respuesta="
				+ respuesta + " ]";
	}
	
}