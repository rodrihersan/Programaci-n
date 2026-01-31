package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EmpleadoHoras {
	private int id;
	private String nombre;
	private double[] horasTrabajadas = new double[7];
	private double tarifaHora;

	public void pedirDatos(ArrayList<EmpleadoHoras> empleados) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		
		do {
			idGenerado = rand.nextInt(10) + 1;
			System.err.println("He generado el numero: " + idGenerado);
		} while (estaRepetido(empleados, idGenerado));
		
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;
		
		boolean datosOk = false;
		do {
			try {
				System.out.println("Introduce el nombre del empleado: ");
				nombre = leer.readLine();
				
				// Validación de la tarifa (mismo estilo que las notas de Alumno)
				do {
					System.out.println("Introduce la tarifa por hora: ");
					tarifaHora = Double.parseDouble(leer.readLine());
					if (tarifaHora <= 0) {
						System.out.println("La tarifa tiene que ser mayor que 0");
					}
				} while (tarifaHora <= 0);
				
				// Inicializar array a 0
				for (int i = 0; i < horasTrabajadas.length; i++) {
					horasTrabajadas[i] = 0;
				}
				
				datosOk = true;
			} catch (IOException | NumberFormatException e) {
				System.out.println("Error en la entrada de datos");
			}
		} while (datosOk == false);
	}

	private boolean estaRepetido(ArrayList<EmpleadoHoras> empleados, int idGenerado) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getId() == idGenerado) {
				System.err.println("El numero esta repetido");
				return true;
			}
		}
		return false;
	}

	public void registrarHoras() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		try {
			// Validación del día (0-6)
			int dia;
			do {
				System.out.println("Introduce el día (0-6): ");
				dia = Integer.parseInt(leer.readLine());
				if (dia < 0 || dia > 6) {
					System.out.println("Error: El día debe estar entre 0 y 6");
				}
			} while (dia < 0 || dia > 6);

			// Validación de las horas (0-24)
			double horas;
			do {
				System.out.println("Introduce las horas trabajadas (0-24): ");
				horas = Double.parseDouble(leer.readLine());
				if (horas < 0 || horas > 24) {
					System.out.println("Error: Las horas deben estar entre 0 y 24");
				}
			} while (horas < 0 || horas > 24);

			// Si llega aquí, los datos son correctos
			horasTrabajadas[dia] = horas;
			
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error: Introduce un número válido");
		}
	}

	public double calcularSumatorio() {
		double total = 0;
		for (int i = 0; i < horasTrabajadas.length; i++) {
			total = total + horasTrabajadas[i];
		}
		return total;
	}

	public double calcularSalario() {
		return calcularSumatorio() * tarifaHora;
	}

	public int obtenerDiaMax() {
		int diaMax = 0;
		for (int i = 1; i < horasTrabajadas.length; i++) {
			if (horasTrabajadas[i] > horasTrabajadas[diaMax]) {
				diaMax = i;
			}
		}
		return diaMax;
	}

	public boolean tieneDiaLibre() {
		for (int i = 0; i < horasTrabajadas.length; i++) {
			if (horasTrabajadas[i] == 0) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", horas=" + Arrays.toString(horasTrabajadas) + "]";
	}
	
	public int contarDiasLibres() {
	    int contador = 0;
	    for (int i = 0; i < horasTrabajadas.length; i++) {
	        if (horasTrabajadas[i] == 0) {
	            contador++;
	        }
	    }
	    return contador;
	}

	public int getId() { return id; }
	public String getNombre() { return nombre; }
	public double[] getHorasTrabajadas() { return horasTrabajadas; }
}