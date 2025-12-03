package EjerciciosFinales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio43 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		
		int[][] puntuaciones = new int[8][7];
		String[] nombresEquipo = new String[8];
		int[] estadoEquipos = new int[8];
		
		do {
			System.out.println("SISTEMA DE GESTIÓN DE TORNEO DE VIDEOJUEGOS");
			System.out.println("Opción 1: Registro de Equipos");
			System.out.println("Opción 2: Registrar Puntuación de Jornada.");
			
			int opcion = leerInt("Introduce una opcion: ");
			
			switch(opcion) {
			case 1:
				opcion1(puntuaciones,nombresEquipo, estadoEquipos);
				break;
			case 2:
				opcion2(puntuaciones,nombresEquipo, estadoEquipos);
				break;
			case 3:
				opcion3(puntuaciones,nombresEquipo, estadoEquipos);
				break;
			default:
				System.out.println("Opcion no valida");
			}
			
		}while(!salir);

	}
	
	
	
	
	public static void opcion3(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) {
		System.out.println("--- TABLA DE CLASIFICACIÓN ---");
		
		System.out.print("\t\t");
		for(int i=0; i<puntuaciones[0].length; i++) {
			System.out.print("J" + (i+1) + "\t\t");
		}
		System.out.println("TOTAL");
		
		for(int f=0; f<puntuaciones.length; f++) {
			System.out.print(nombresEquipo[f] + "\t\t");
			int total = 0;
			for(int c=0; c<puntuaciones[f].length; c++) {
				System.out.print(puntuaciones[f][c] + "\t\t" );
				total += puntuaciones[f][c];
			}
			System.out.println(total);
		}
		
	}




	public static void opcion2(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws NumberFormatException, IOException {
		System.out.println("--- REGISTRAR PUNTUACIÓN ---");
		
		System.out.println("EQUIPOS");
		for(int i=0; i<nombresEquipo.length; i++) {
			System.out.print(i + ". " + nombresEquipo[i]);
			if(estadoEquipos[i] == 0)
				System.out.println(" [ACTIVO]");
			else
				System.out.println(" [DESCALIFICADO");
		}
		
		int posEquipo = -1;
		boolean activo;
		do {
			activo = true;
			posEquipo = leerInt("Introduce el índice del equipo (0-7): ");
			if(posEquipo<0 || posEquipo>7) {
				System.out.println("El numero introducido no esta entre 0 y 7");
			}else {
				if(estadoEquipos[posEquipo] == 1) {
					System.out.println("Este equipo está descalificado y no puede competir.");
					activo = false;
				}
			}
				
		}while(posEquipo<0 ||  posEquipo>7 || activo == false);
		
		int numeroJornada = -1;
		do {
			numeroJornada = leerInt("Introduce el numero de jornada (1-7): ");
			if(numeroJornada<1 || numeroJornada>7) 
				System.out.println("El numero introducido no esta entre 1 y 7");
				
		}while(numeroJornada<1 ||  numeroJornada>7);
		
		int puntuacionObtenida = -1;
		do {
			puntuacionObtenida = leerInt("Introduce la puntuacion (0-100): ");
			if(puntuacionObtenida<0 || puntuacionObtenida>100) 
				System.out.println("El numero introducido no esta entre 0 y 100");
				
		}while(puntuacionObtenida<0 ||  puntuacionObtenida>100);
		
		
		puntuaciones[posEquipo][numeroJornada-1] = puntuacionObtenida;
		System.out.println("Registrado correctamente. El equipo " + nombresEquipo[posEquipo] + 
				" ha obtenido en la jornada " + numeroJornada + " la puntuacion " + puntuacionObtenida);
		
		
	}




	public static void opcion1(int[][] puntuaciones, String[] nombresEquipo, int[] estadoEquipos) throws IOException {
		System.out.println("--- REGISTRO DE EQUIPOS ---");
		
		for(int i=0; i<nombresEquipo.length; i++) {
			String nombre;
			do {
				nombre = leerString("Introduce nombre del equipo " + (i+1));
			}while(nombre.isEmpty() || hayDuplicados(nombre, nombresEquipo));
			
			nombresEquipo[i] = nombre;
		}
		
		for(int f=0; f<puntuaciones.length; f++) {
			for(int c=0; c<puntuaciones[f].length; c++)
				puntuaciones[f][c] = 0;
			
		}
		
		for(int i=0; i<estadoEquipos.length; i++)
			estadoEquipos[i] = 0;
		
	}
	
	public static boolean hayDuplicados(String nombre, String[] nombresEquipo) {
		boolean hayDuplicados = false;
		for(int i=0; i<nombresEquipo.length; i++)
			if(nombresEquipo[i] != null) {
				if(nombresEquipo[i].equalsIgnoreCase(nombre)) {
					hayDuplicados = true;
					System.out.println("El nombre esta duplicado");
				}
			}	
		return hayDuplicados;
	}




	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	
	public static String leerString(String mensaje) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		return leer.readLine();
	}

}