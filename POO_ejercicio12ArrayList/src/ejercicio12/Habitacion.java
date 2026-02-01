package ejercicio12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Habitacion {
	private int codigo;
	private String tipo; // individual, doble, suite
	private double precioNoche;
	private boolean ocupada;
	private String nombreCliente;

	public Habitacion() {
	}

	public void pedirDatos(ArrayList<Habitacion> hotel) throws IOException {
		Random rand = new Random();
		int codGen;
		
		// Generar código único entre 100 y 200
		do {
			codGen = rand.nextInt(101) + 100;
		} while (estaRepetido(hotel, codGen));
		
		codigo = codGen;
		System.out.println("Código de habitación asignado: " + codigo);
		
		// Validación de tipo
		do {
			System.out.print("Tipo de habitación (individual/doble/suite): ");
			tipo = Principal.leerLinea().toLowerCase();
			if (!tipo.equals("individual") && !tipo.equals("doble") && !tipo.equals("suite")) {
				System.out.println("Error: El tipo debe ser individual, doble o suite.");
			}
		} while (!tipo.equals("individual") && !tipo.equals("doble") && !tipo.equals("suite"));
		
		System.out.print("Precio por noche: ");
		precioNoche = Principal.leerDoublePositivo();
		
		ocupada = false;
		nombreCliente = "Ninguno";
	}

	private boolean estaRepetido(ArrayList<Habitacion> hotel, int cod) {
		for (Habitacion h : hotel) {
			if (h.getCodigo() == cod) return true;
		}
		return false;
	}

	public void ocupar(String nombre) {
		if (!ocupada) {
			nombreCliente = nombre;
			ocupada = true;
			System.out.println("Habitación ocupada con éxito.");
		} else {
			System.out.println("Error: La habitación ya está ocupada.");
		}
	}

	public void liberar() {
		ocupada = false;
		nombreCliente = "Ninguno";
		System.out.println("Check-out realizado. Habitación libre.");
	}

	public void aplicarDescuento(double porcentaje) {
		if (!ocupada) {
			precioNoche = precioNoche - (precioNoche * (porcentaje / 100));
			System.out.println("Descuento aplicado. Nuevo precio: " + precioNoche);
		} else {
			System.out.println("Error: No se puede cambiar el precio de una habitación ocupada.");
		}
	}

	@Override
	public String toString() {
		String estado = ocupada ? "OCUPADA (Huésped: " + nombreCliente + ")" : "LIBRE";
		return "Habitación [" + codigo + "] Tipo: " + tipo + " | Precio: " + precioNoche + "€ | Estado: " + estado;
	}

	// Getters
	public int getCodigo() { return codigo; }
	public boolean isOcupada() { return ocupada; }
	public String getTipo() { return tipo; }
	public double getPrecioNoche() { return precioNoche; }
}