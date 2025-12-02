package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	int[] array1 = new int[5]; //seria 10 pero lo acortamos a 5
		
		for(int i=0; i < array1.length; i++) {
			array1[i] = leerInt("Introduce un numero: ");
		}
		
		int pos1 = leerInt("Introduce un numero de posicion: ");
		while(pos1 < 0 || pos1 > array1.length) {
			System.out.println("Posicion incorrecta. Introduce un num entre 0 y " + array1.length);
			pos1 = leerInt("Introduce un numero de posicion: ");
		}
		
		int pos2 = leerInt("Introduce un numero de posicion: ");
		while(pos2 < 0 || pos2 > array1.length) {
			System.out.println("Posicion incorrecta. Introduce un num entre 0 y " + array1.length);
			pos2 = leerInt("Introduce un numerode posicion: ");
		}
		

		for(int i=0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		
		int temporal = array1[pos1];
		array1[pos1] = array1[pos2];
		array1[pos2] = temporal;
		
		System.out.println(" ");
		for(int i=0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		
	}

	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
	}
