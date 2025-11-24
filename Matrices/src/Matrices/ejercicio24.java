package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio24 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][] matriz = new int [3][5];
		
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
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		
		for(int fila = 0; fila<matriz.length; fila++) {
			for(int columna = 0; columna < matriz[fila].length;columna++) {	
				if(matriz[fila][columna] > 0)
					positivos++;
				else if(matriz[fila][columna] < 0)
					negativos++;
				else
					ceros++;
			}
		}
		System.out.println("Hay " + positivos+ "positivos, y " + negativos +
				"negativos, y " + ceros+ " ceros");
	}

	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
