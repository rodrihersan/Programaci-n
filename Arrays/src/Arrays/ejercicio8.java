package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[12];
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = leerInt("Introduzca un numero: ");
		}
		
		int numPar = 0;
		int numImpar = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] %2 ==0 )
				numPar++;
			else
				numImpar++;
		}
		System.out.println("Hay " + numPar+ "pares, y " + numImpar +
				"impares");
	}
	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	}
