package examen1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		System.out.println("Concursantes de Operacion Triunfo");
		System.out.println("---------------------------------");
		System.out.print("Dime tu nombre: ");
		String nombre = lector.readLine();
		System.out.print("Dime tu año de nacimiento: ");
		int añoNacimiento = Integer.parseInt(lector.readLine());
		System.out.print("¿Has sido expulsado? Responda si o no (S/N): ");
		String expulsion = lector.readLine();
			
		System.out.println("Dime tu puntuacion media en las galas: ");
		double puntuacionMedia = Double.parseDouble(lector.readLine());
		System.out.println("----------------------------------");
		
		System.out.println("Concursante guardado correctamente");
		System.out.println("¿Quiere ver el concursante guardado? (S/N): ");
		char concursanteGuardado = lector.readLine().toUpperCase().charAt(0);
		
		if(concursanteGuardado == 's' || concursanteGuardado == 'S') {
			int añosEdad = 2025-añoNacimiento;
			boolean expusion = true;
			System.out.println(nombre + ", "+ añosEdad + " años, expulsado: " + expulsion + " puntuacion media: " + puntuacionMedia);}
		else if(concursanteGuardado == 'n' || concursanteGuardado == 'N'){
			System.out.println("Saliendo del programa");}
		else {
			System.out.print("Opcion erroa");
			

	
	
	}
	}
}