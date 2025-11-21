package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[8];
		
		for(int i=0; i<numeros.length; i++) {
			try {
				numeros[i] = leerInt("Introduzca un numero " + (i+1) + " ");
			}catch (Exception e) {
				System.out.println("Numero introducido  no valido");
				numeros[i] = 0;
			}
		}
		
		for(int i = 0; i<numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}