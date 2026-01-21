package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce nombre: ");
		String nombre = leer.readLine();
		System.out.println("Introduce nacimiento: ");
		int añoNacimiento = Integer.parseInt(leer.readLine());
		System.out.println("Introduce Nota media : ");
		double notaMedia = Double.parseDouble(leer.readLine());
		
		Alumno a = new Alumno(nombre, añoNacimiento, notaMedia);
		
		System.out.println(a.getNombre() + " "  + a.getNacimiento() + " " + a.getnotaMedia());
		System.out.println(a.toString());
		
		System.out.println(a.calcularEdadActual());
		
		a.hasAprobado();
		
		
		Alumno a2 = new Alumno("dkldsh", 2005, 4);
		System.out.println(a2.calcularEdadActual());
		
		a2.hasAprobado();
		
		Alumno a3_sinNota = new Alumno("pepito", 2006);
		System.out.println(a3_sinNota.toString());
		
		Alumno a4 = new Alumno();
		System.out.println(a4.toString());
		
		/* Crea un método calcularEdad, que muestre la edad
		Un método notaMedia que imprima si estas aprobado o no (>5) */
	}
	

}