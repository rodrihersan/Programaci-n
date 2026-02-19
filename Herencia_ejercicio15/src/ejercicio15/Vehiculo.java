package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Vehiculo {
	private int matricula;
	private String marca;
	private String modelo;
	private double precioBaseDia;

	public void pedirDatos(ArrayList<Vehiculo> vehiculos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		Random rand = new Random();
		int matriculaGenerada = -1;
		do {
			matriculaGenerada = rand.nextInt(9000) + 1000;
		} while (matriculaRepetida(vehiculos, matriculaGenerada));
		this.matricula = matriculaGenerada;
		System.out.println("Matricula asignada: " + this.matricula);

		boolean datosOk = false;
		do {
			try {
				System.out.print("Introduce la marca: ");
				this.marca = leer.readLine();

				System.out.print("Introduce el modelo: ");
				this.modelo = leer.readLine();

				boolean precioOk = false;
				while (!precioOk) {
					try {
						System.out.print("Introduce el precio base por dia: ");
						this.precioBaseDia = Double.parseDouble(leer.readLine());
						precioOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				datosOk = true;
			} catch (IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);
	}

	private boolean matriculaRepetida(ArrayList<Vehiculo> vehiculos, int matriculaGenerada) {
		for (int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula() == matriculaGenerada) {
				return true;
			}
		}
		return false;
	}

	public void mostrarDatos() {
		System.out.println("Matricula: " + this.matricula);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Precio base por dia: " + this.precioBaseDia);
	}

	public int getMatricula() {
		return matricula;
	}

	public double getPrecioBaseDia() {
		return precioBaseDia;
	}

}
