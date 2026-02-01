package ejercicio12;

import java.io.IOException;
import java.util.Random;

public class Habitacion {
	private int codigo;
	private String tipo; // individual, doble, suite
	private double precioNoche;
	private boolean ocupada;
	private String nombreCliente;

	public Habitacion() {
	}

	public void pedirDatos(Habitacion[] hotel) throws IOException {
		Random rand = new Random();
		int codGen;
		
		// Generar código único entre 100 y 200 para el array
		do {
			codGen = rand.nextInt(101) + 100;
		} while (estaRepetido(hotel, codGen));
		
		codigo = codGen;
		System.out.println("Código asignado: " + codigo);
		
		do {
			System.out.print("Tipo (individual/doble/suite): ");
			tipo = Principal.leerLinea().toLowerCase();
		} while (!tipo.equals("individual") && !tipo.equals("doble") && !tipo.equals("suite"));
		
		System.out.print("Precio por noche: ");
		precioNoche = Principal.leerDoublePositivo();
		
		ocupada = false;
		nombreCliente = "Ninguno";
	}

	private boolean estaRepetido(Habitacion[] hotel, int cod) {
		for (int i = 0; i < hotel.length; i++) {
			if (hotel[i] != null && hotel[i].getCodigo() == cod) {
				return true;
			}
		}
		return false;
	}

	public void ocupar(String nombre) {
		if (!ocupada) {
			nombreCliente = nombre;
			ocupada = true;
			System.out.println("Habitación ocupada por " + nombreCliente);
		} else {
			System.out.println("Error: Ya está ocupada.");
		}
	}

	public void liberar() {
		ocupada = false;
		nombreCliente = "Ninguno";
		System.out.println("Habitación liberada.");
	}

	@Override
	public String toString() {
		String estado = ocupada ? "OCUPADA por " + nombreCliente : "LIBRE";
		return "Hab [" + codigo + "] " + tipo + " - " + precioNoche + "€ - " + estado;
	}

	public int getCodigo() { return codigo; }
	public boolean isOcupada() { return ocupada; }
	public String getTipo() { return tipo; }
	public double getPrecioNoche() { return precioNoche; }
}