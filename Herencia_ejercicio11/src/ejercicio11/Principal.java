package ejercicio11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

	public static void main(String[] args) {
		boolean salir = false;
		do {
			System.out.println(" === HOSPITAL === ");
			System.out.println("1. Registrar paciente");
			System.out.println("2. Añadir tratamiento a paciente urgencias ");
			System.out.println("3. Añadir consulta a paciente cita previa");
			System.out.println("4. Mostrar historial de un paciente.");
			System.out.print("Introduce una opción: ");
			int opcion = leerInt(leer);
			
			switch (opcion) {
			case 1:registrarJugador(jugadores);break;
			case 2:mostrarJugadores(jugadores);break;
			case 3:matar(jugadores);break;
			case 4:salir = true;System.out.println("Saliendo del sistema :c ");break;
			default:System.out.println("Opción no válida.");
		}	
	}while (!salir);
}

	

}
