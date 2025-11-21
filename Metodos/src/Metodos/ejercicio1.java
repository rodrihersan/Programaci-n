package Metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce tu nombre");
		String nom = lector.readLine();
		saludo(nom);
		String saludo = saludoConString(nom);
		System.out.println(saludo);
	}
	public static void saludo(String nombre) {
		String nom;
		System.out.println("Hola " + nombre);
	}
	public static String saludoConString(String nombre) {
		String n = "Hola" + nombre;
		return n;
	}
}
