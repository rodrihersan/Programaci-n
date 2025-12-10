package coleccionesDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio5 {
	
	public static int leerInt() throws IOException, NumberFormatException {
		 
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		boolean valido = false;
		while (!valido) {
			try {
				num = Integer.parseInt(leer.readLine());
				valido = true;
			} catch (NumberFormatException e) {
				System.err.print("ERROR. ");
				System.out.println("Introduce un número válido: ");
			}
		}
		return num;
	}
	
//--------------------	
	
	public static int leerIntPositivo() throws IOException, NumberFormatException {
	    int numero = leerInt();
	    while (numero < 0) {
	        System.err.print("ERROR. ");
	        System.out.println("El número no puede ser negativo. Intentalo de nuevo: ");
	        numero = leerInt();
	    }
	    return numero;
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		ArrayList<Integer> numeros = new ArrayList<>();

		int numero;
		do {
			System.out.println("Introduce un numero: ");
			numero =leerInt();
			if(numero != -1)
				numeros.add(numero);
		}while(numero != -1);
		
		int sumaTotal=0;
		for(int n:numeros) {
			sumaTotal+= n;
		}
		
		System.out.println("La suma es: "+ sumaTotal);					
	}
}
