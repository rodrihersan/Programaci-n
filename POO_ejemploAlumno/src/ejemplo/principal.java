package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class principal {

	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce nombre: ");
		String nombre = leer.readLine();
		System.out.println("Introduce nacimiento: ");
		int añoNacimiento= Integer.parseInt(leer.readLine());
		System.out.println("Introduce nota media: ");
		double notaMedia = Double.parseDouble(leer.readLine());
		alumno a = new Alumno(nombre, añoNacimiento, notaMedia);
		
		System.out.println(a.getNombre()+ " "+ a.getNacimiento()+ " "+ a.getnotaMedia());
		System.out.println(a.toString());
	}

}
