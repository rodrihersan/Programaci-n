package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[10];
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = leerInt("Introduce el numero " + (i + 1) + " de 10: ");
		}
		
		int X = leerInt("Introduzca un número: ");
		
		int contador = 0;
        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] > X) {
                contador++;
            }
        }
        
        int[] mayores = new int[contador];
        int indice = 0;
        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] > X) {
                mayores[indice] = numeros[i];
                indice++;
            }
        }

        System.out.println("Números mayores que " + X + ":");
        for(int i = 0; i < mayores.length; i++) {
            System.out.print(mayores[i] + " ");
        }
    }
	
	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
}
