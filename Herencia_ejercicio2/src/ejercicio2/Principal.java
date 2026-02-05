package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	
	public static int leerInt() throws IOException {
		 
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un nï¿½mero vï¿½lido: ");
			}
		}
		return num;
	}

	public static void main(String[] args) throws IOException{
		ArrayList<Trabajador> empleados = new ArrayList<Trabajador>();
		
		boolean salir = false;
		
		do {
			System.out.println();
		System.out.println("1. REGISTRO DE EQUIPOS ");
		System.out.println("2. REGISTRAR PUNTUACIÓN ");
		System.out.println("3. TABLA DE CLASIFICACIÓN ");
		System.out.println("4. ANÁLISIS DE RENDIMIENTO ");
		System.out.println("5. DESCALIFICAR EQUIPO ");
		System.out.println("6. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		//case 1:opcion1();break;
		//case 2:opcion2(puntuaciones,nombresEquipo,estadoEquipos);break;
		//case 3:opcion3(puntuaciones,nombresEquipo,estadoEquipos);break;
		//case 4:opcion4(puntuaciones,nombresEquipo,estadoEquipos);break;
		//case 5:;break;
		case 6:salir = true;System.out.println("¡Hasta luego!");break;
		default:System.err.println("Opción no válida.");
			}
		}while(!salir);
	}
	
	private static void añadirEmpleadoCompleto(ArrayList<Trabajador> empleados) {
		int id = 1;
		if(empleados.size() > 0)
			id = empleados.getLast().getId()+1;
		
	}
		
}

