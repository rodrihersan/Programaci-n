package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer_14_15 {

	public static void main(String[] args) throws IOException{
		BufferedReader leer5 = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub

		//14. Crea un programa que:
		//	Pida al usuario su nombre
		//	Pida 3 notas de exámenes
		//	Calcule la nota media
		//	Muestre: "Hola [nombre], tu nota media es: [media]"
		
		System.out.print("Dame tu nombre: ");
		String textoUsuario = leer5.readLine();
		System.out.println("Dame tres notas de tus exámenes: ");
		System.out.print("\t" + "Nota del primer examen: ");
		float n1 = Float.parseFloat(leer5.readLine());
		System.out.print("\t" + "Nota del segundo examen: ");
		float n2 = Float.parseFloat(leer5.readLine());
		System.out.print("\t" + "Nota del tercer examen: ");
		float n3= Float.parseFloat(leer5.readLine());
		
		float media = (n1 + n2 + n3) / 3;
		System.out.println("Hola " + textoUsuario + "," + " tu nota media es: " + media);
		
		//15. Solicita al usuario: 
		//Nombre y apellidos, Año de nacimiento, Ciudad donde vive, Profesión.
		//Luego calcula y muestra:
		//Edad actual
		//Un mensaje: "Te llamas [nombre], tienes [edad] años, vives en [ciudad] y trabajas
		//como [profesión]"
		//La inicial de su nombre y apellido
		
		System.out.print("Dame tu nombre y apellidos: ");
		String textoUsuario2 = leer5.readLine();
		System.out.print("Dame tu año de nacimiento: ");
		int edad = Integer.parseInt(leer5.readLine());
		System.out.print("Dime la ciudad donde vives: ");
		String textoUsuario4 = leer5.readLine();
		System.out.print("Dime tu profesion: ");
		String textoUsuario5= leer5.readLine();
		int edadactual = (2025 - edad);
		System.out.println("Te llamas " + textoUsuario2 + ", tienes " + edadactual + 
				" años, vives en " + textoUsuario4 + " y trabajas como " + textoUsuario5);
		
		
		
		
	}

}
