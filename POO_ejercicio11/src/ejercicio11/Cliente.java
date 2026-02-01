package ejercicio11;

import java.io.IOException;
import java.util.Random;

public class Cliente {
	private int numeroSocio;
	private String nombre;
	private String ciudad;
	private String tipo; // normal, premium, vip
	private int puntos;

	public Cliente() {
	}

	public void pedirDatos(Cliente[] club) throws IOException {
		Random rand = new Random();
		int numGen;
		
		// Generar número de socio único entre 1 y 500
		do {
			numGen = rand.nextInt(500) + 1;
		} while (estaRepetido(club, numGen));
		
		numeroSocio = numGen;
		System.out.println("Número de socio asignado: " + numeroSocio);
		
		System.out.print("Nombre del cliente: ");
		nombre = Principal.leerLinea();
		
		System.out.print("Ciudad: ");
		ciudad = Principal.leerLinea();
		
		// Validación de tipo
		do {
			System.out.print("Tipo de cliente (normal/premium/vip): ");
			tipo = Principal.leerLinea().toLowerCase();
			if (!tipo.equals("normal") && !tipo.equals("premium") && !tipo.equals("vip")) {
				System.out.println("Error: El tipo debe ser normal, premium o vip.");
			}
		} while (!tipo.equals("normal") && !tipo.equals("premium") && !tipo.equals("vip"));
		
		puntos = 0; // Empieza con 0 puntos
	}

	private boolean estaRepetido(Cliente[] club, int num) {
		for (int i = 0; i < club.length; i++) {
			if (club[i] != null && club[i].getNumeroSocio() == num) {
				return true;
			}
		}
		return false;
	}

	public void sumarPuntos(int cantidad) {
		puntos = puntos + cantidad;
	}

	public boolean canjearPuntos(int cantidad) {
		if (puntos >= cantidad) {
			puntos = puntos - cantidad;
			return true;
		}
		return false;
	}

	public int obtenerDescuento() {
		if (tipo.equals("vip")) return 20;
		if (tipo.equals("premium")) return 10;
		return 0;
	}

	@Override
	public String toString() {
		return "Socio [" + numeroSocio + "] " + nombre + " (" + ciudad + ") | Tipo: " + tipo + 
			   " | Puntos: " + puntos + " | Dto: " + obtenerDescuento() + "%";
	}

	// Getters necesarios
	public int getNumeroSocio() { return numeroSocio; }
	public String getTipo() { return tipo; }
	public int getPuntos() { return puntos; }
}