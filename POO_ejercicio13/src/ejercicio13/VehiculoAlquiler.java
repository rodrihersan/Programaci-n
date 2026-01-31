package ejercicio13;

import java.io.IOException;
import java.util.Random;

public class VehiculoAlquiler {
	private int matricula;
	private String marca;
	private String modelo;
	private String categoria; 
	private double precioDia;
	private boolean alquilado;

	public void pedirDatos(VehiculoAlquiler[] flota) throws IOException {
		Random rand = new Random();
		int matGen;
		
		// Matrícula aleatoria única
		do {
			matGen = rand.nextInt(9000) + 1000; 
		} while (estaRepetida(flota, matGen));
		
		matricula = matGen; // Sin "this"
		System.out.println("Matrícula generada: " + matricula);
		
		System.out.println("Introduce la marca: ");
		marca = Principal.leerLinea();
		
		System.out.println("Introduce el modelo: ");
		modelo = Principal.leerLinea();
		
		// Validación de categoría (economico, estandar, lujo)
		do {
			System.out.println("Categoría (economico/estandar/lujo): ");
			categoria = Principal.leerLinea().toLowerCase();
			if (!categoria.equals("economico") && !categoria.equals("estandar") && !categoria.equals("lujo")) {
				System.out.println("Error: Solo se permite economico, estandar o lujo.");
			}
		} while (!categoria.equals("economico") && !categoria.equals("estandar") && !categoria.equals("lujo"));
		
		System.out.println("Precio por día: ");
		precioDia = Principal.leerDoublePositivo();
		
		alquilado = false; 
	}

	private boolean estaRepetida(VehiculoAlquiler[] flota, int mat) {
		for (int i = 0; i < flota.length; i++) {
			if (flota[i] != null && flota[i].getMatricula() == mat) {
				return true;
			}
		}
		return false;
	}

	public double calcularPrecioFinal(int dias) {
		double total = precioDia * dias;
		if (dias >= 15) {
			total = total * 0.80; // 20% dto
		} else if (dias >= 7) {
			total = total * 0.90; // 10% dto
		}
		return total;
	}

	@Override
	public String toString() {
		String estado = alquilado ? "ALQUILADO" : "LIBRE";
		return "Vehículo [" + matricula + "] " + marca + " " + modelo + 
			   " | Cat: " + categoria + " | Precio: " + precioDia + "€ | Estado: " + estado;
	}

	// Getters y Setters necesarios
	public int getMatricula() { return matricula; }
	public boolean isAlquilado() { return alquilado; }
	public void setAlquilado(boolean estado) { alquilado = estado; }
	public String getCategoria() { return categoria; }
	public double getPrecioDia() { return precioDia; }
}
