package ejercicio10;

import java.io.IOException;
import java.util.Random;

public class Empleado {
	private String dni;
	private String nombre;
	private String departamento;
	private double salario;

	// Constructor vacío necesario para el array
	public Empleado() {
	}

	public void pedirDatos(Empleado[] plantilla) throws IOException {
		// 1. Generar DNI único
		dni = generarDniUnico(plantilla);
		System.out.println("DNI asignado automáticamente: " + dni);

		// 2. Nombre
		System.out.print("Introduce el nombre: ");
		nombre = Principal.leerLinea();

		// 3. Departamento con validación
		do {
			System.out.print("Departamento (ventas/marketing/produccion/administracion): ");
			departamento = Principal.leerLinea().toLowerCase();
			if (!esDepartamentoValido(departamento)) {
				System.out.println("Error: Departamento no permitido.");
			}
		} while (!esDepartamentoValido(departamento));

		// 4. Salario
		System.out.print("Introduce el salario: ");
		salario = Principal.leerDoublePositivo();
	}

	public static boolean esDepartamentoValido(String dep) {
		String d = dep.toLowerCase();
		return d.equals("ventas") || d.equals("marketing") || 
			   d.equals("produccion") || d.equals("administracion");
	}

	private static String generarDniUnico(Empleado[] plantilla) {
		Random rand = new Random();
		String nuevoDni;
		boolean repetido;
		do {
			repetido = false;
			nuevoDni = String.valueOf(rand.nextInt(90000000) + 10000000);
			// Buscamos en el array normal controlando los nulls
			for (int i = 0; i < plantilla.length; i++) {
				if (plantilla[i] != null && plantilla[i].getDni().equals(nuevoDni)) {
					repetido = true;
					break;
				}
			}
		} while (repetido);
		return nuevoDni;
	}

	public void aumentarSalario(double porcentaje) {
		salario = salario + (salario * (porcentaje / 100));
	}

	@Override
	public String toString() {
		return "Empleado [DNI=" + dni + ", Nombre=" + nombre + ", Dep=" + departamento + ", Salario=" + salario + "€]";
	}

	public String getDni() { return dni; }
	public String getDepartamento() { return departamento; }
	public double getSalario() { return salario; }
}