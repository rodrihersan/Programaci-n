package controlador;

import java.util.ArrayList;
import modelo.PeliculaDAO;
import modelo.PeliculaDTO;

public class PeliculaController {
	public ArrayList<PeliculaDTO> obtenerTodasLasCategorias(){
		PeliculaDAO PeliculDAO = new PeliculaDAO();
		return PeliculDAO.obtenerTodosLasCategorias();
	}
	
	public boolean insertar(PeliculaDTO pelicula) {
		PeliculaDAO PeliculDAO = new PeliculaDAO();
		return PeliculaDAO.insertarCategoria(pelicula);
	}
}