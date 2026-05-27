package vista;

import java.io.IOException;
import java.util.ArrayList;
import controlador.PeliculaController;
import modelo.PeliculaDTO;
import Utils.Lecturas;



public class vistaPelicula {
	
	public void menuCategoria() throws IOException {
		boolean salir = false;
		do {
			System.out.println("=== Peliculas ===");
			System.out.println("1. Listar películas");
			System.out.println("2. Añadir pelï¿½cula");
			System.out.println("3. Editar pelï¿½cula");
			System.out.println("4. Borrar pelï¿½cula");
			System.out.println("0. Volver");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opciï¿½n: ", 0, 4);
			switch (opcion) {
			case 1:System.out.println("= Listar pelï¿½culas =");verTodasLasCategorias();break;
			case 2:System.out.println("= Aï¿½adir pelï¿½cula =");insertar();break;
			case 3:System.out.println("= Editar pelï¿½cula =");break;
			case 4:System.out.println("= Borrar pelï¿½cula =");break;
			case 0:salir = true;break;
			}
		} while (!salir);
	}
	
	public void verTodasLasCategorias() {
		PeliculaController peliculaControlador = new PeliculaController();
		ArrayList<PeliculaDTO> listaPeliculas = peliculaControlador.obtenerTodasLasPeliculas();
		
		System.out.println("CATEGORIAS");
		System.out.println("--------------");
		for (PeliculaDTO pelicula : listaPeliculas) {
			System.out.println(pelicula.getPelicula()+ " - " + pelicula.getNombrePelicula());
		}
	}
	
	public void insertar() {
		String titulo  = Lecturas.leerString("Introduce el título: ");
	    String genero  = Lecturas.leerString("Introduce el género: ");
	    int duracion   = Lecturas.leerEnteroEnRango("Introduce la duración (min): ", 1, 999);
	    int anio       = Lecturas.leerEnteroEnRango("Introduce el año: ", 1888, 2100);
	    
		PeliculaDTO pel = new PeliculaDTO(titulo, genero, duracion, anio);
		PeliculaController categoriaControlador = new PeliculaController();
		
		if(categoriaControlador.insertar(pel))
			System.out.println("Insertado correctamente");
		else
			System.out.println("Error al insertar");
	}
}