package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio14 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] array1 = new int[10];
		for(int i=0; i < array1.length; i++) {
			array1[i] = leerInt("Introduce un numero: ");
		}
	
		boolean haySecuencia = false;
        int numConsecutivo = 1; // Contador de la longitud de la secuencia actual

        for (int i = 1; i < array1.length; i++) {
            // Comprueba si el número actual es el consecutivo del anterior
            if (array1[i] == array1[i - 1] + 1) {
                numConsecutivo++;
            } else {
                // Si la secuencia se rompe, se reinicia el contador.
                numConsecutivo = 1;
            }
            
            // Verificamos si la longitud de la secuencia actual ya alcanza 3
            if (numConsecutivo >= 3) {
                haySecuencia = true;
                break; // Podemos parar la búsqueda tan pronto como encontramos una
            }
        }

        // 3. Resultado
        System.out.println("Resultado");
        System.out.println("Array introducido: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        if (haySecuencia) {
            System.out.println("El array CONTIENE una secuencia de al menos 3 números consecutivos.");
        } else {
            System.out.println("El array NO contiene una secuencia de al menos 3 números consecutivos.");
        }
    }
	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
	}