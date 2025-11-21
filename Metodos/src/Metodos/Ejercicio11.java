package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Introduce un numero: ");
		int N = leerInt();
		imprimirNumeros(N);

	}

	public static void imprimirNumeros(int numero) {
		if (numero == 1)
			System.out.println(1);
		else {
			System.out.println(numero);
			imprimirNumeros(numero - 1);
		}
	}

	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
