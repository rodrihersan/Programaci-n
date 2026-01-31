package ejercicio16;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class EmpleadoHoras {
	private int id;
	private String nombre;
	private double[] horasTrabajadas = new double[7];
	private double tarifaHora;

	public void pedirDatos(EmpleadoHoras[] empleados) throws IOException {
		Random rand = new Random();
		int idGenerado = -1;
		
		do {
			idGenerado = rand.nextInt(10) + 1;
		} while (estaRepetido(empleados, idGenerado));
		
		this.id = idGenerado;
		System.out.println("Asignado ID: " + id);
		
		System.out.println("Introduce el nombre del empleado: ");
		this.nombre = Principal.leerLinea(); // USA TU MÉTODO
		
		System.out.println("Introduce la tarifa por hora: ");
		this.tarifaHora = Principal.leerDoublePositivo(); // USA TU MÉTODO
		
		// Inicializar array a 0
		for (int i = 0; i < horasTrabajadas.length; i++) {
			horasTrabajadas[i] = 0;
		}
	}

	private boolean estaRepetido(EmpleadoHoras[] empleados, int idGenerado) {
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] != null && empleados[i].getId() == idGenerado) {
				return true;
			}
		}
		return false;
	}

	public void registrarHoras() throws IOException {
		int dia;
		do {
			System.out.println("Introduce el día (0-6): ");
			dia = Principal.leerInt(); // USA TU MÉTODO
			if (dia < 0 || dia > 6) System.out.println("Error: Día entre 0 y 6.");
		} while (dia < 0 || dia > 6);

		double horas;
		do {
			System.out.println("Introduce las horas trabajadas (0-24): ");
			horas = Principal.leerDouble(); // USA TU MÉTODO
			if (horas < 0 || horas > 24) System.out.println("Error: Horas entre 0 y 24.");
		} while (horas < 0 || horas > 24);

		horasTrabajadas[dia] = horas;
	}

	public double calcularSumatorio() {
		double total = 0;
		for (double h : horasTrabajadas) total += h;
		return total;
	}

	public double calcularSalario() {
		return calcularSumatorio() * tarifaHora;
	}

	public int contarDiasLibres() {
		int contador = 0;
		for (double h : horasTrabajadas) {
			if (h == 0) contador++;
		}
		return contador;
	}

	@Override
	public String toString() {
		return "Empleado [ID=" + id + ", Nombre=" + nombre + ", Horas=" + Arrays.toString(horasTrabajadas) + "]";
	}

	public int getId() { return id; }
	public String getNombre() { return nombre; }
}