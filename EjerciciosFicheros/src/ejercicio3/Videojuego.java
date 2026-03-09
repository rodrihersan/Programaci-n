package ejercicio3;

import java.util.ArrayList;

public class Videojuego {
	private String nombre;
	private ArrayList<Integer> notas;
	
	public Videojuego(String nombre) {
	    this.nombre = nombre;
	    notas = new ArrayList<Integer>();
	}
	
	public void añadirNotas(int nota) {
		notas.add(nota);
	}
	
	
	
	
	public double calcularMedia() {
		int suma = 0;
		for(int nota : notas) {
			suma = suma+ nota;
		}
		
		double notaMedia = suma / notas.size();
		return notaMedia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Integer> getNotas() {
		return notas;
	}
	
	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}
	
}
