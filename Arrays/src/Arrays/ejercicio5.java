package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] numeros = new int[8];
		for (int i=0; i < numeros.length; i++) {
			numeros[i] = leerInt("Introduce el numero " + (i + 1) + ": ");
		}
		int numMayor = numeros[0];
		int posMayor=0;
		int numMenor = numeros[0];
		int posMenor = 0;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] > numMayor) {
				numMayor = numeros[i];
				posMayor = i;
			}else if(numeros[i] < numMenor)
				numMenor = numeros[i];
				posMenor = i;
			}
		
	//opcion2 - Como sabemos la posicion no hace falta que guardemos el valor mayor o menor
	posMayor=0;
	posMenor=0;
	for(int i =0; i<numeros.length; i++) {
		if(numeros[i] > numeros[posMayor]) {
			posMayor = i;
		}else if(numeros[i] < numeros[posMenor]) {
			posMenor= i;
			}
		}
	System.out.println("El numero mayor es " + numeros[posMayor] + " y su posicion es " + posMayor);
	System.out.println("El numero menor es " + numeros[posMenor] + " y su posicion es " + posMenor);
	}
	public static int leerInt(String mensaje) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		int num = Integer.parseInt(leer.readLine());
		return num;
		}
}
