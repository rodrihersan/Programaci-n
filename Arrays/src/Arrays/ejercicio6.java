package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[7];
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = leerInt("Introduce un numero: ");
		}
		
		int sumaTotal = 0;
		for(int i = 0; i < numeros.length; i++) {
			sumaTotal += numeros[i];
		}
		
		double media = sumaTotal / (double) numeros.length;
		
		int numPorArriba = 0;
		int numPorAbajo = 0;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] > media)
				numPorArriba++;
			else if(numeros[i] < media)
				numPorAbajo++;
		}
		
		System.out.println("La media es " + media);
		System.out.println("Hay " + numPorArriba + " numeros por arriba");
		System.out.println("Hay " + numPorAbajo + " numeros por abajo");
		

	}
	
	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}

}
