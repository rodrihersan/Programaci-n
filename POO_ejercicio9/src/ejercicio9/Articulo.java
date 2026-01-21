package ejercicio9;

import java.util.ArrayList;
import java.util.Random;

public class Articulo {
	private int id;
	private String nombre;
	
	public void pedirDatos(ArrayList<Articulo>  articulos) {
		Random rand = new Random();
		
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(30)+1;
			System.err.println("He generado el numero: " + idGenerado);
		}while(estaRepetido(articulos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;
	
		
		
	}
	
	private boolean estaRepetido(ArrayList<Articulo>  articulos, int idGenerado) {
		for(int i = 0; i < (articulos.size() - 1); i++) {
			if(articulos.get(i).getId() == idGenerado) {
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