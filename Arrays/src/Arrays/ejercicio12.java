package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio12 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] array1 = new int[6];
		for(int i=0; i<array1.length; i++) {
			array1[i] = leerInt("Introduce el numero " + (i + 1) + " de 6 (primer array): ");
		}
		
		int[] array2 = new int[6];
		for(int i=0; i<array2.length; i++) {
			array2[i] = leerInt("Introduce el numero " + (i + 1) + " de 6 (primer array): ");
		}
		
		int coincidencias = 0;
        for(int i = 0; i < array1.length; i++) {
            if(array1[i] == array2[i]) {
                coincidencias++;
            }
        }
        
        System.out.println("Número de posiciones con el mismo valor: " + coincidencias);
    }

	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
	}