package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Alumno {
	private int expediente;
	private String nombre;
	private ArrayList<Integer> notas = new ArrayList<Integer>();
	
	public void pedirDatos(ArrayList<Alumno> alumnos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean datosOK = false;
		while (!datosOK) {
			try {					
					System.out.print("Introduce tu nombre: ");
			        String nombre = leer.readLine();
			        
			        boolean encontrado = false;
			        int notas ;
			        do {
			        	System.out.println("Escribe las notas: ");
			        	notas = Integer.parseInt(leer.readLine());
			        	encontrado = true;
			        }while (notas < 0 || notas > 10 && !encontrado);				
				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}
		}
	}

}
