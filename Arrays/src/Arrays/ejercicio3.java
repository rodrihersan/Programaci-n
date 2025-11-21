package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		double[] numeros = new double[6];
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = leerDouble("Introduzca un numero " + (i+1) + " ");
			}
		double sumaTotal=0;
		for(int i = 0; i<numeros.length; i++) {
			sumaTotal = sumaTotal + numeros[i];
		}
		System.out.println("La suma es: " + sumaTotal);
	}
	public static double leerDouble(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		double num = Double.parseDouble(leer.readLine());
		return num;
	}
}