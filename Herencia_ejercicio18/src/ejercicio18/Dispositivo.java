package ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Dispositivo {
	private int codigo;
	private String marca;
	private String modelo;
	private double precioBase;
	private int mesesGarantia;

	public void pedirDatos(ArrayList<Dispositivo> dispositivos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		Random rand = new Random();
		int codigoGenerado = -1;
		do {
			codigoGenerado = rand.nextInt(900) + 100;
		} while (codigoRepetido(dispositivos, codigoGenerado));
		this.codigo = codigoGenerado;
		System.out.println("Codigo asignado: " + this.codigo);

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
						System.out.print("Introduce el precio base: ");
						this.precioBase = Double.parseDouble(leer.readLine());
						precioOk = true;
					} catch (NumberFormatException e) {
						System.err.println("Solo puedes introducir numeros");
					}
				}

				boolean garantiaOk = false;
				while (!garantiaOk) {
					try {
						System.out.print("Introduce los meses de garantia: ");
						this.mesesGarantia = Integer.parseInt(leer.readLine());
						garantiaOk = true;
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

	private boolean codigoRepetido(ArrayList<Dispositivo> dispositivos, int codigoGenerado) {
		for (int i = 0; i < dispositivos.size(); i++) {
			if (dispositivos.get(i).getCodigo() == codigoGenerado) {
				return true;
			}
		}
		return false;
	}

	public double calcularGarantiaExtendida() {
		return precioBase + (mesesGarantia * 5);
	}

	public void mostrarDatos() {
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Precio base: " + this.precioBase);
		System.out.println("Meses de garantia: " + this.mesesGarantia);
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public int getMesesGarantia() {
		return mesesGarantia;
	}

}