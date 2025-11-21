package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[10];
		for (int i=0; i < numeros.length; i++) {
			numeros[i] = leerInt("Introduce el numero " + (i + 1) + ": ");
		}
		System.out.println("El primero numero es: " + numeros[0]);
		//numeros.length nos devuelve 10, -1 = 9, ultima posicion
		System.out.println("El ultimo numero es : " + numeros[numeros.length - 1]); 
		
		for (int i=0; i < numeros.length; i++) {
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