package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio36 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean salir = false;
		char [][] butacas = new char [6][8];
		
		for(int fila = 0; fila<butacas.length; fila++)
			for(int columna = 0; columna < butacas[fila].length;columna++)
				butacas[fila][columna] = 'L';
		do {
			System.out.println("=== RESERVA DE ASIENTOS ===");
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("--- MENÚ PRINCIPAL ---");
			System.out.println("1. Mostrar mapa de asientos");
			System.out.println("2. Reservar asiento");
			System.out.println("3. Cancelar reserva");
			System.out.println("4. Contar asientos libres y ocupados");
			System.out.println("5. Mostrar qué fila tiene más asientos libres");
			System.out.println("6. Comprobar si una fila específica está completamente llena");
			System.out.println("7. Mostrar porcentaje de ocupación del cine");
			System.out.println("8. Reiniciar sala");
			System.out.println("9. Salir");
			//System.out.print("Elige una opción: ");
			int opcion = leerInt("Elige una opción: ");

			switch (opcion) {			
				case 1:mapaAsientos(butacas);break;
				case 2:reservaAsientos(butacas);break;
				case 3:cancelarReserva(butacas);break;
				case 4:contarAsientos(butacas);break;
				case 5:moostrarAsientosFila(butacas);break;
				//case 6:comprobarFila();break;
				//case 7:montrarPorcentaje();break;
				//case 8:reiniciarSala();break;
				case 9:salir = true;
				System.out.println("Saliendo de la aplicación");break;
				default:System.err.println("Opción no válida");
				}
			} while (!salir);
		}
	
	public static void mapaAsientos(char[][] butacas) throws NumberFormatException, IOException {

		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				System.out.print(butacas[fila][columna] + "|");
			}
			System.out.println();
		}
	}
		
	public static void reservaAsientos(char[][] butacas)  throws NumberFormatException, IOException{
		int f = leerInt("Introduce la fila");
		int c = leerInt("Introduce la columna");
		
		boolean encontrado = false;
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(fila == f && columna == c) {
					encontrado = true;
					if(butacas[fila][columna] == 'L') {
						butacas[fila][columna] = 'X';
						System.out.println("Asiento reservado correctamente");
					}else {
						System.out.println("No se puede reservar asiento. Esta ocupado");
					}
				}
			}
		}
		if(encontrado == false)
			System.out.println("Has introducido una fila y/o una columna que no existen");
		}
	
	public static void cancelarReserva(char[][] butacas)  throws NumberFormatException, IOException{
		int f = leerInt("Introduce la fila");
		int c = leerInt("Introduce la columna");
		
		boolean encontrado = false;
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(fila == f && columna == c) {
					encontrado = true;
					if(butacas[fila][columna] == 'X') {
						butacas[fila][columna] = 'L';
					}else {
						System.out.println("Reserva cancelada correctamente");
					}System.out.println("No se puede cancelar porque ya esta libre");
				}
			}
		}
		if(encontrado == false)
			System.out.println("Has introducido una fila y una columna que no existen");
		}

	public static void contarAsientos(char[][] butacas)  throws NumberFormatException, IOException{
		int asientosLibres = 0;
		int asientosOcupados = 0;
		
		for(int fila = 0; fila<butacas.length; fila++) {
			for(int columna = 0; columna < butacas[fila].length;columna++) {
				if(butacas[fila][columna] == 'L') {
					asientosLibres++;
				}else if(butacas[fila][columna] == 'X'){
					asientosOcupados++;
				}
			}
		}
		System.out.println("Asientos totales: " + (asientosLibres+asientosOcupados));
		System.out.println("Asientos libres: "+ (asientosLibres));
		System.out.println("Asientos ocupados: "+ (asientosOcupados));
	}
	
	public static void moostrarAsientosFila(char[][] butacas)  throws NumberFormatException, IOException{
		
	}
	
	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
