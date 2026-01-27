package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Alumno {
	private int id;
	private String nombre;
	private String asignatura;
	private double[] notas = new double[6];
	private int numNotas; 
	
	
	public void pedirDatos(ArrayList<Alumno> alumnos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(30) + 1;
			System.err.println("He generado el numero: " + idGenerado);
		} while (estaRepetido(alumnos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;
		boolean datosOk = false;

		do {
			try {
				System.out.println("Introduce el nombre del alumne: ");
				nombre = leer.readLine();
				
				System.out.println("Introduce el nombre de la asignatura: ");
				asignatura = leer.readLine();
				
				numNotas = 0;
				datosOk = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}while(datosOk == false);
	

		
	}
	
	public void añadirNota() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		//Tengo comprobar si puedo añadir nota
		if(numNotas >= notas.length - 1)
			System.out.println("No se puede añadir más notas a ese alumno");
		else {
			try {
				do {
					System.out.println("Introduce la nota " + (numNotas + 1) + " del alumno " + nombre);
					notas[numNotas] = Integer.parseInt(leer.readLine());
					if(notas[numNotas] < 0 || notas[numNotas] > 10)
						System.out.println("La nota tiene que estar entre 1 y 10");
				}while(notas[numNotas] < 0 || notas[numNotas] > 10);
				numNotas++;
			} catch (NumberFormatException | IOException e) {
				System.out.println("Introduce una nota valida");
			}
		}
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", asignatura=" + asignatura + ", notas="
				+ Arrays.toString(notas) + "]";
	}

	private boolean estaRepetido(ArrayList<Alumno> alumnos, int idGenerado) {
		for (int i = 0; i < alumnos.size()-1; i++) {
			if (alumnos.get(i).getId() == idGenerado) {
				System.err.println("El numero esta repetido");
				return true;
			}

		}
		return false;

	}

	public int getId() {
		return id;
	}
	
}