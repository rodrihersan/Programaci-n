package ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Persona {
	private int DNI;
	private String nombre;
	private int edad;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	
	
	protected void pedirDatos(ArrayList<Deportista> deportistas) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(99999999) + 10000000;
		} while (estaRepetido(deportistas, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		DNI = idGenerado;
		
		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce el nombre: ");
				nombre = leer.readLine();
				
				do {
					System.out.print("Introduce la edad: ");
					edad = Integer.parseInt(leer.readLine());
					if (edad < 0)
						System.out.println("La edad no puede ser negativa");
				} while (edad < 0);
				
				System.out.print("Introduce la nacionalidad: ");
				nacionalidad = leer.readLine();

				System.out.print("Introduce la fecha (dd/MM/yyyy): ");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String fechaTemp = leer.readLine();
				fechaNacimiento = LocalDate.parse(fechaTemp, formato);
				

				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}

		
	}

	private boolean estaRepetido(ArrayList<Deportista> deportistas, int idGenerado) {
		for (int i = 0; i < (deportistas.size() - 1); i++) {
			if (deportistas.get(i).getDNI() == idGenerado) {
				return true;
			}

		}
		return false;

	}

	public int getDNI() {
		return DNI;
	}
	
	public void mostrarDatos() {
		System.out.println("DNI: " + this.DNI);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Edad: " + this.edad);
		System.out.println("Nacimiento: " + this.fechaNacimiento);
		System.out.println("Nacionalidad: " + this.nacionalidad);

	}
	
}