package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio27 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][] matriz = new int [5][3];
		for(int fila = 0; fila<matriz.length; fila++) {
			for(int columna = 0; columna < matriz[fila].length;columna++) {
				matriz[fila][columna] = leerInt("Introduce un numero para " 
						+ fila + "x" + columna + ": ");
			}
		}
		
		for (int fila = 0; fila<matriz.length; fila++) {
			for(int columna = 0; columna < matriz[fila].length;columna++) {
				System.out.print(matriz[fila][columna]+ "\t");
				}
			System.out.println("");
		}
		
	int[] sumaTotal = new int [matriz[0].length];
	for(int fila =0; fila<matriz.length; fila++) {
		for(int columna=0; columna<matriz[fila].length;columna++) {
			sumaTotal[columna]=matriz[fila][columna];
	}
	}
	}
	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
