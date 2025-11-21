package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[10];
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = leerInt("Introduzca un numero: ");	
		}
		
		int numPositivos = 0;
		int numNegativos = 0;
		int numCero = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] > 0)
				numPositivos++;
			else if(numeros[i] < 0)
				numNegativos++;
			else
				numCero++;
		}
		System.out.println("Hay " + numPositivos+ "positivos, y " + numNegativos +
				"negativos, y " + numCero+ " ceros");
		}

	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
