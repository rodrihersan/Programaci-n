package ejercicio10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Empleado {
	private String dni;
	private String nombre;
	private String departamento;
	private double salario;

	public void pedirDatos(ArrayList<Empleado> plantilla) throws IOException {
		// 1. Generar DNI único automáticamente
		dni = generarDniUnico(plantilla);
		System.out.println("DNI generado automáticamente: " + dni);

		// 2. Pedir nombre
		System.out.print("Introduce el nombre del empleado: ");
		nombre = Principal.leerLinea();

		// 3. Pedir departamento con validación
		do {
			System.out.print("Departamento (ventas/marketing/produccion/administracion): ");
			departamento = Principal.leerLinea().toLowerCase();
			if (!esDepartamentoValido(departamento)) {
				System.out.println("Error: El departamento no existe.");
			}
		} while (!esDepartamentoValido(departamento));

		// 4. Pedir salario
		System.out.print("Introduce el salario: ");
		salario = Principal.leerDoublePositivo();
	}

	// Método estático para validar si el departamento es correcto
	public static boolean esDepartamentoValido(String dep) {
		String d = dep.toLowerCase();
		return d.equals("ventas") || d.equals("marketing") || 
			   d.equals("produccion") || d.equals("administracion");
	}

	// Método privado para la lógica del DNI único
	private static String generarDniUnico(ArrayList<Empleado> plantilla) {
		Random rand = new Random();
		String nuevoDni;
		boolean repetido;
		do {
			repetido = false;
			nuevoDni = String.valueOf(rand.nextInt(90000000) + 10000000);
			for (Empleado e : plantilla) {
				if (e.getDni().equals(nuevoDni)) {
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

	// Getters
	public String getDni() { return dni; }
	public String getDepartamento() { return departamento; }
	public double getSalario() { return salario; }
}