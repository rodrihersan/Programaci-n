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
	
	public void verCalificaciones() {
		System.out.println("Mostrando notas de " + nombre);
		
		double notaMinima = 11;
		double notaMaxima = -1;
		
		if(numNotas > 0) {
			for(int i =0; i<= numNotas; i++) {
				System.out.println(notas[i]+" , ");
				if(notas[i] < notaMinima) 
					notaMinima = notas[i];
				if(notas[i] > notaMaxima)
					notaMaxima = notas[i];
			}
			System.out.println("");
			System.out.println("Nota maxima "+ notaMaxima);
			System.out.println("Nota minima "+ notaMinima);
		}else {
			System.out.println("El alumno " + nombre + "no tiene notas aún");
		}
	}
	
	public void mostrarMedia() {
		if(numNotas > 0) {
			double media = 0;
			for(int i=0; i<numNotas; i++) {
				media = media+notas[i];
			}
			media=media/numNotas;
			System.out.println("La media es: "+media);
		}else {
			System.out.println("El alumno "+nombre+ "no tiene notas aún para hacer la media");
		}
	}
	
	public double devolverMedia() {
		if(numNotas > 0) {
			double media = 0;
			for(int i=0; i<numNotas; i++) {
				media = media+notas[i];
			}
			return media;
		}else {
			return -1;
		}
	}
	
	
	
	public int getId() {
		return id;
	}
	
	public double[] getNotas() {
		return notas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumNotas() {
		return numNotas;
	}
	
}