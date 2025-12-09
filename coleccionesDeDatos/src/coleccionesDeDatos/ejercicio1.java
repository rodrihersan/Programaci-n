package coleccionesDeDatos;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {
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
		
	//--------------------	
		public static int leerIntPositivo() throws IOException {
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
		
		for(int i =0;i<5;i++) {
			System.out.println("Introduce un numero: ");
			int n=leerIntPositivo();
			numeros.add(n);
		}
		for(int n : numeros)
			System.out.println(n);
		
		System.out.println();
		
		System.out.println(numeros.get(2));
		
		System.out.println("size "+ numeros.size());
		
		numeros.remove(3);
		
		for(int n : numeros)
			System.out.println(n + " ");
		
		System.out.println();
		
		System.out.println("Contiene el 5?: " + numeros.contains(5));
	}

}
