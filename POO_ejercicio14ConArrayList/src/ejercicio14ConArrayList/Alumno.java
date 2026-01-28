package ejercicio14ConArrayList;

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
	// SUSTITUIDO: double[] por ArrayList
	private ArrayList<Double> notas = new ArrayList<>(); 
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
		// Nota: Con ArrayList no hay límite teórico, pero mantenemos la lógica de control si lo deseas
		try {
			double notaIntroducida;
			do {
				System.out.println("Introduce la nota " + (numNotas + 1) + " del alumno " + nombre);
				notaIntroducida = Double.parseDouble(leer.readLine());
				if(notaIntroducida < 0 || notaIntroducida > 10)
					System.out.println("La nota tiene que estar entre 0 y 10");
			} while(notaIntroducida < 0 || notaIntroducida > 10);
			
			notas.add(notaIntroducida); // Añadimos al ArrayList
			numNotas++;
		} catch (NumberFormatException | IOException e) {
			System.out.println("Introduce una nota valida");
		}
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", asignatura=" + asignatura + ", notas="
				+ notas.toString() + "]"; // ArrayList ya tiene un buen toString
	}

	private boolean estaRepetido(ArrayList<Alumno> alumnos, int idGenerado) {
		// Ajustado a size() para evitar errores de índice
		for (int i = 0; i < alumnos.size(); i++) {
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
			for(Double nota : notas) { // Recorrido más limpio con for-each
				System.out.print(nota + " , ");
				if(nota < notaMinima) 
					notaMinima = nota;
				if(nota > notaMaxima)
					notaMaxima = nota;
			}
			System.out.println("");
			System.out.println("Nota maxima "+ notaMaxima);
			System.out.println("Nota minima "+ notaMinima);
		} else {
			System.out.println("El alumno " + nombre + " no tiene notas aún");
		}
	}
	
	public void mostrarMedia() {
		if(numNotas > 0) {
			double media = 0;
			for(Double nota : notas) {
				media = media + nota;
			}
			media = media / numNotas;
			System.out.println("La media es: " + media);
		} else {
			System.out.println("El alumno " + nombre + " no tiene notas aún para hacer la media");
		}
	}
	
	public double devolverMedia() {
		if(numNotas > 0) {
			double suma = 0;
			for(Double nota : notas) {
				suma = suma + nota;
			}
			return suma / numNotas;
		} else {
			return -1;
		}
	}
	
	public int getId() {
		return id;
	}
	
	// Cambiado el tipo de retorno a ArrayList<Double>
	public ArrayList<Double> getNotas() {
		return notas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumNotas() {
		return numNotas;
	}
	
	public int contarSuspensos() {
	    int contador = 0;
	    for (Double nota : notas) {
	        if (nota < 5) {
	            contador++;
	        }
	    }
	    return contador;
	}
}