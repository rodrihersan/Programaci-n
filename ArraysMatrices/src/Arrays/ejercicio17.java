package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio17 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[11];

        for (int i = 1; i < 11; i++) {
            System.out.print("Introduce el número "+i+" : ");
            numeros[i] = leerInt();
        }

        System.out.println("Números ingresados:");
        for (int i = 1; i < 11; i++) {
            System.out.print(numeros[i] + " ");
        }
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public static int leerInt() throws IOException {
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
		
		public static int leerIntPositivo() throws IOException {
		    int numero = leerInt();
		    while (numero < 0) {
		        System.err.print("ERROR. ");
		        System.out.println("El número no puede ser negativo. Intentalo de nuevo: ");
		        numero = leerInt();
		    }
		    return numero;
		}
	}
