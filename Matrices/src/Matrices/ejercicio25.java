package Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio25 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][] matriz = new int [4][4];
		
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
		
	int buscar = leerInt("Introduce el número a buscar: ");
	
	boolean encontrado = false;
    System.out.println("El número se encuentra en la posición: ");
    for (int fila = 0; fila<matriz.length; fila++) {
    	for(int columna = 0; columna < matriz[fila].length;columna++) {
        if (matriz[fila][columna] == buscar) {
            encontrado = true;
        }
        System.out.print("el numero eta en la posicion ["+fila+ "]["+columna+"]");
    }
    	

    if (!encontrado) {
        System.out.println("El número no se encuentra en la matriz.");
    } else {
        System.out.println();
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