package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteCitaPrevia extends Paciente {
	private String especialidadMedica;
	private LocalDate[] consultas = new LocalDate[10];
	private int numCitas;

	public void pedirDatos(int id) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(id);

		boolean datosOk = false;
		do {

			try {

				System.out.print("Introduce la especialidad medica ");
				this.especialidadMedica = leer.readLine();

				numCitas = 0;
				datosOk = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Ha habido un error con los datos" + e.getStackTrace());
			}
		} while (!datosOk);

	}

	public boolean añadirCita() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numCitas < 10) {
			String fechaUsuario;
			boolean datosOk = false;
			LocalDate fecha = null;
			do {
				try {
					System.out.println("Añadir fecha de la cita en formato dd/mm/yyyy: ");
					fechaUsuario = leer.readLine();
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					fecha = LocalDate.parse(fechaUsuario, formato);
					datosOk = true;
				} catch (Exception e) {
					System.out.println("La fecha estaba en formato incorrecto");
				}
			} while (!datosOk);

			consultas[numCitas] = fecha;
			return true;

		} else {
			return false;
		}

	}
	
	public void mostrarDatos() {
		super.mostrarDatos();

		System.out.println("Especialidad Medica: " + this.especialidadMedica);
		
		for(LocalDate fecha: consultas) {
			System.out.print(fecha + " ");
		}
		
		System.out.println("");
		System.out.println("----------------------------");
			

	}

}