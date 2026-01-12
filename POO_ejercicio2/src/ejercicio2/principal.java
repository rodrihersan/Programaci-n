package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce tu nombre: ");
		String nombre = leer.readLine();
		System.out.println("Introduce la permanencia (años): ");
		int permanencia = Integer.parseInt(leer.readLine());
		System.out.println("Introduce el salario: ");
		double salario = Double.parseDouble(leer.readLine());
		
		empleado empleado1 = new empleado(nombre, permanencia, salario);
		System.out.println(empleado1.getNombre() + " "  + empleado1.clasificacion());
		
		System.out.println(empleado1.getNombre() + " "  + empleado1.getPermanencia() + " " + empleado1.getSalario());
		
		System.out.println(empleado1.toString());
		
		System.out.println("Introduce el porcentaje que tendra un empleado aplicado a su salario: ");
		double porcentaje = Double.parseDouble(leer.readLine());
		System.out.println("El nuevo salario es " + empleado1.calcularNuevoSalario(porcentaje));
	}

}
