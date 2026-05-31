package vista;

import java.util.ArrayList;
import controlador.PeliculaController;
import modelo.PeliculaDTO;
import utils.Lecturas;

public class VistaPelicula {
	PeliculaController peliculaController = new PeliculaController();
	
	public void menuPeliculas(){
		boolean salir = false;
		do {
			System.out.println("=== Gestion Peliculas ===");
			System.out.println("1. Listar peliculas");
			System.out.println("2. Añadir peliculas");
			System.out.println("3. Editar peliculas");
			System.out.println("4. Borrar peliculas");
			System.out.println("0. Volver");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
			
			switch (opcion) {
			
			case 1:System.out.println("Listar peliculas");verTodasLasPeliculas();break;			
			case 2:System.out.println("Añadir peliculas");insertar();break;
			case 3:System.out.println("Editar peliculas");editar();break;
			case 4:System.out.println("Borrar peliculas");borrar();break;
			case 0:salir = true;break;
			}
		} while (!salir);
	}
	
	public void verTodasLasPeliculas() {
		ArrayList<PeliculaDTO> lista = peliculaController.obtenerTodasLasPeliculas();
		
		System.out.println("Peliculas");
		System.out.println("--------------");
		if (lista.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (PeliculaDTO p : lista) {
                System.out.println(p.getId() + " | " + p.getTitulo() + " | " + p.getGenero() + " | " + p.getDuracion() + " min | " + p.getAnio());
            }
        }
    }
	
	public void insertar() {
		String titulo = Lecturas.leerString("Introduce el titulo: ");
	    String genero = Lecturas.leerString("Introduce el genero: ");
	    int duracion = Lecturas.leerEnteroEnRango("Introduce la duracion (min): ", 1, 999);
	    int anio = Lecturas.leerEnteroEnRango("Introduce el año: ", 1888, 2100);
	    
		PeliculaDTO nueva = new PeliculaDTO(titulo, genero, duracion, anio);
		PeliculaController peliculaControlador = new PeliculaController();
		
		if (peliculaControlador.insertar(nueva))
            System.out.println("Película añadida correctamente.");
        else
            System.out.println("Error al añadir la película.");
    }
	
	public void editar() {
		int id = Lecturas.leerEntero("Id de la película a editar: ");

	    String titulo = Lecturas.leerString("Nuevo título: ");
	    String genero = Lecturas.leerString("Nuevo género: ");
	    int duracion = Lecturas.leerEnteroEnRango("Nueva duración (min): ", 1, 999);
	    int anio = Lecturas.leerEnteroEnRango("Nuevo año: ", 1888, 2100);

	    PeliculaDTO editada = new PeliculaDTO(id, titulo, genero, duracion, anio);

	    if (peliculaController.editar(editada))
	        System.out.println("Película actualizada correctamente.");
	    else
	        System.out.println("Error al actualizar la película (id no existe o fallo).");
	}
	
	public void borrar() {
        int id = Lecturas.leerEntero("Id de la película a borrar: ");
        PeliculaController peliculaController = new PeliculaController();
        
        if (peliculaController.borrar(id))
            System.out.println("Película borrada correctamente.");
        else
            System.out.println("Error al borrar la película.");
    }
}