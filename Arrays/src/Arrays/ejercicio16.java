package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio16 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tamañoArray = leerInt("Introduce el tamaño del array: ");
		int[] numeros = new int[tamañoArray];
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 100 + 1);
		}
		
		boolean salir = false;
		do {
			System.out.println("1. Recorrer el array");
			System.out.println("2. Sumar los elementos del array");
			System.out.println("3. Encontrar numero maximo");
			System.out.println("4. Encontrar la media");
			System.out.println("5. Buscar un num");
			System.out.println("6. Contar las veces que aparece");
			System.out.println("7.  Invertir el array");
			System.out.println("8. Crear un nuevo array");
			System.out.println("9. Salir");
			
			int opcion = leerInt("Introduce una opcion: ");
			
			switch(opcion) {
				case 1:
					opcion1(numeros);
					break;
				case 2:
					int suma = opcion2(numeros);
					System.out.println("La suma de los num del array es: " + suma);
					break;
				case 3:
					int numMax = opcion3(numeros);
					System.out.println("El numero maximo es: " + numMax);
					break;
				case 4:
					double media = opcion4(numeros);
					System.out.println("La media es: " + media);
					break;
				case 5:
					opcion5(numeros);
					break;
				case 6:
					int numVeces = opcion6(numeros);
					if(numVeces == 0)
						System.out.println("El numero no aparece");
					else
						System.out.println("El numero aparece " + numVeces + " veces") ;
						
					break;
				case 7:
					opcion7(numeros);
					break;
				case 8:
					opcion8(numeros, tamañoArray);
					break;
				case 9:
					salir = true;
					System.out.println("Salir");
					break;
				default:
					System.out.println("Opcion invalida");
					break;
			}
			
			
		}while(!salir);
		
	}
	
	// OPCION 1 - RECORRER ARRAY
	public static void opcion1(int[] numeros) {
		System.out.println("Recorriendo array");
		System.out.print("[ ");
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		System.out.println("]");
		
	}
	
	//OPCION 2 - SUMAR LOS ELEMENTOS DEL ARRA
	public static int opcion2(int[] numeros) {
		System.out.println("Sumando array");
		
		int sumaTotal = 0;
		for(int i = 0; i < numeros.length; i++) {
			sumaTotal = sumaTotal + numeros[i];
		}
		
		return sumaTotal;	
	}
	
	//OPCION 3 - NUMERO MAXIMO
	public static int opcion3(int[] numeros) {
		System.out.println("Buscando num maximo del array");
		
		int numMaximo = numeros[0];
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] > numMaximo)
				numMaximo = numeros[i];
		}
		
		return numMaximo;	
	}
	
	//OPCION 4 - CALCULAR MEDIA
	public static double opcion4(int[] numeros) {
		System.out.println("Calcular media array");
		
		int suma = opcion2(numeros);
		double media = suma / numeros.length;
		
		
		return media;	
	}
	

	//OPCION 5 - BUSCAR NUMEROS
	public static void opcion5(int[] numeros) throws NumberFormatException, IOException {
		System.out.println("Buscar un elemento.");
		
		int numABuscar = leerInt("Introduce un numero a buscar: ");
		
		boolean encontrado = false;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == numABuscar) {
				System.out.println("El numero esta en la posicion " + i);
				encontrado = true;
			}
		}
		
		if(encontrado == false)
			System.out.println("No hemos encontrado el numero :(");
	}
	
	//OPCION 6 - BUSCAR NUMEROS
	public static int opcion6(int[] numeros) throws NumberFormatException, IOException {
		System.out.println("Contar las veces que aparece un elemento.");
		
		int numABuscar = leerInt("Introduce un numero a buscar: ");
		
		int contador = 0;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == numABuscar) {
				contador++;
			}
		}
		return contador;
	}
	
	//OPCION 7 - INVERTIR NUMEROS
	public static void opcion7(int[] numeros) throws NumberFormatException, IOException {
		System.out.println("Invertir numeros");
		
		int temporal;
		for(int i = 0; i < numeros.length/2; i++) {
			temporal = numeros[i];
			numeros[i] = numeros[numeros.length - 1-i];
			numeros[numeros.length - 1-i] = temporal;
		}
		
		opcion1(numeros);
	}
	
	//OPCION 8 - Nuevo array
		public static void opcion8(int[] numeros, int tamaño) throws NumberFormatException, IOException {
			System.out.println("Nuevo array");
			
			int[] numeros2 = new int[tamaño];
			
			for(int i = 0; i < numeros2.length; i++) {
				numeros2[i] = leerInt("Introduce un numero: ");
			}
			
			boolean sonIguales = false;
			for(int i = 0; i < numeros.length; i++) {
				if(numeros[i] == numeros2[i]) {
					System.out.println("Los valores de la posicion " + i + " son iguales");
					sonIguales = true;
				}
			}
			
			if(sonIguales == false)
				System.out.println("Ninguna posicion es igual");
		
		}



	public static int leerInt(String mensaje) throws NumberFormatException, IOException  {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
	}

}
