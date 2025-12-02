package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[8];
			for (int i=0; i < numeros.length; i++) {
				numeros[i] = leerInt("Introduce el numero " + (i + 1) + ": ");
		}
		 int[] invertido = new int[8];
	        for (int i = 0; i < numeros.length; i++) {
	            invertido[i] = numeros[numeros.length - i];
	        }
	        
	        System.out.println("Array original: ");
	        for (int i = 0; i < numeros.length; i++) {
	            System.out.println(numeros[i] + " ");
	        }
	        System.out.println();
	        System.out.println("Array invertido: ");
	        for (int i = 0; i < invertido.length; i++) {
	            System.out.println(invertido[i] + " ");
	        }
	}	
	
	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
}
