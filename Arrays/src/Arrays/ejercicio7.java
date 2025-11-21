package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		double[] numeros = new double[7];
		for (int i = 0; i < numeros.length; i++) {
            numeros[i] = leerDouble("Introduce el número " + (i + 1) + ": ");
        }
		
		double buscar = leerDouble("Introduce el número a buscar: ");
		
		boolean encontrado = false;
        System.out.print("El número se encuentra en la posición: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscar) {
                System.out.print(i + " ");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El número no se encuentra en el array.");
        } else {
            System.out.println();
        }
    }
	
		public static double leerDouble(String mensaje) throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(mensaje);
			double num = Double.parseDouble(leer.readLine());
			return num;
		}
	}
