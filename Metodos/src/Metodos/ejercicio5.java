package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {
	
	
	public static int resto(int num1) {
		return num1 %2;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String respuesta;
		
		//¡¡EJERCICIO MODIFICADO, NO PIDE HACER BUCLE, SOLO SI ES PAR/IMPAR AL METER NUMERO!!
		
		
		//Se ejecuta mediante respuesta
		do{
			System.out.println("Introduce un numero: ");
			int num1 = Integer.parseInt(lector.readLine());
			if(num1 % 2==0) {
				System.out.println("Es par");
			}else {
				System.out.println("No es par");
			}
			System.out.print("¿Desea introducir más números? (s/n): ");
	        respuesta = lector.readLine();
			
			}while(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s"));
		
		/*Se ejecuta mediante numero
		
		while(true) {
			System.out.print("Introduce un numero (mete 0 para salir): ");
			int num1 = Integer.parseInt(lector.readLine());

			if(num1 == 0) {
				System.out.println("Fin del programa.");
				break; //el break hace que se salga del bucle al poner el 0. ¡¡Adri no quiere esto!!
			}
			
			if(resto(num1) == 0) {
				System.out.println("Es par");
			}else {
				System.out.println("No es par");
			}
		}*/
	}

}
