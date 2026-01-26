package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Articulo {
	private int id;
	private String nombre;
	private float precio;
	private int stock;

	public void pedirDatos(ArrayList<Articulo> articulos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();

		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(30) + 1;
			System.err.println("He generado el numero: " + idGenerado);
		} while (estaRepetido(articulos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;

		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce el nombre del estudiante: ");
				nombre = leer.readLine();

				do {
					System.out.println("Introduce el precio: ");
					precio = Float.parseFloat(leer.readLine());
					if (precio < 0)
						System.out.println("Tienes que introducir un precio mayor de 0");
				} while (precio < 0);

				do {
					System.out.println("Introduce el stock: ");
					stock = Integer.parseInt(leer.readLine());
					if (stock < 0)
						System.out.println("Tienes que introducir un stock mayor o igual a 0");
				} while (stock < 0);

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}

	}

	private boolean estaRepetido(ArrayList<Articulo> articulos, int idGenerado) {
		for (int i = 0; i < (articulos.size() - 1); i++) {
			if (articulos.get(i).getId() == idGenerado) {
				System.err.println("El numero esta repetido");
				return true;
			}

		}
		return false;

	}
	
	
	public boolean realizarVenta(int cantAVender) {
		if(stock >= cantAVender)
			return true;
		else
			return false;
	}
	
	public void mostrarDatos() {
		System.out.println("------- ARTICULO " + id+ "------------");
		System.out.println("--------------------------------------");
		System.out.println("\tNOMBRE: " + nombre);
		System.out.println("\tPRECIO: " + precio + " €");
		System.out.println("\tSTOCK: " + stock);
		
		
	}

	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrecio() {
		return precio;
	}

	
}