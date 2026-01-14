package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class libro {
	/*ID SE AÑADE LUEGO*/
	private int id;
	private String titulo;
	private String autor;
	private int añoPublicacion;
	private int numPaginas;
	
	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;
		System.out.print("Introduce el nombre del titulo libro: ");
		titulo = leer.readLine();
		System.out.print("Introduce el autor: ");
		autor = leer.readLine();
		System.out.print("Introduce el año publicacion: ");
		añoPublicacion = Integer.parseInt(leer.readLine());
		System.out.print("Introduce el numero de paginas: ");
		numPaginas = Integer.parseInt(leer.readLine());
	}
	
	public boolean tiene30Años() {
		if ((2026 - añoPublicacion) <= 30) {
			return false;
		}else {
			return true;
		}	
	}
	
	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return "libro [titulo=" + titulo + ", autor=" + autor + ", añoPublicacion=" + añoPublicacion + ", numPaginas="
				+ numPaginas + "]";
	}

	public int getId() {
		return id;
	}
		
	
}
