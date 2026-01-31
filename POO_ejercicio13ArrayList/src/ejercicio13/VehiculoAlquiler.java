package ejercicio13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class VehiculoAlquiler {
	private int matricula;
	private String marca;
	private String modelo;
	private String categoria;
	private double precioDia;
	private boolean alquilado;

	// Ahora el método recibe un ArrayList para comprobar repetidos
	public void pedirDatos(ArrayList<VehiculoAlquiler> flota) throws IOException {
		Random rand = new Random();
		int matGen;
		
		do {
			matGen = rand.nextInt(9000) + 1000;
		} while (estaRepetida(flota, matGen));
		
		matricula = matGen;
		System.out.println("Matrícula: " + matricula);
		
		System.out.print("Marca: ");
		marca = Principal.leerLinea();
		
		System.out.print("Modelo: ");
		modelo = Principal.leerLinea();
		
		do {
			System.out.print("Categoría (economico/estandar/lujo): ");
			categoria = Principal.leerLinea().toLowerCase();
		} while (!categoria.equals("economico") && !categoria.equals("estandar") && !categoria.equals("lujo"));
		
		System.out.print("Precio/día: ");
		// Aquí puedes usar un método auxiliar de la principal si lo tienes, o lectura directa:
		precioDia = Double.parseDouble(Principal.LEER.readLine());
		
		alquilado = false;
	}

	private boolean estaRepetida(ArrayList<VehiculoAlquiler> flota, int mat) {
		for (VehiculoAlquiler v : flota) {
			if (v.getMatricula() == mat) return true;
		}
		return false;
	}

	public double calcularPrecioFinal(int dias) {
		double total = precioDia * dias;
		if (dias >= 15) total *= 0.8;
		else if (dias >= 7) total *= 0.9;
		return total;
	}

	@Override
	public String toString() {
		return "[" + matricula + "] " + marca + " " + modelo + " (" + categoria + ") - " + (alquilado ? "ALQUILADO" : "LIBRE");
	}

	public int getMatricula() { return matricula; }
	public boolean isAlquilado() { return alquilado; }
	public void setAlquilado(boolean estado) { alquilado = estado; }
	public String getCategoria() { return categoria; }
	public double getPrecioDia() { return precioDia; }
}
