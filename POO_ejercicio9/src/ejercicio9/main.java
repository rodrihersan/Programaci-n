package ejercicio9;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		
		for(int i=0; i < 20; i++) {
			articulos.add(new Articulo());
			articulos.getLast().pedirDatos(articulos);
		}

	}

}