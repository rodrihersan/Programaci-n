package controlador;

import java.util.ArrayList;
import modelo.PeliculaDAO;
import modelo.PeliculaDTO;

public class PeliculaController {
    public ArrayList<PeliculaDTO> obtenerTodasLasPeliculas() {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        return peliculaDAO.obtenerTodasLasPeliculas();
    }

    public boolean insertar(PeliculaDTO pelicula) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        return peliculaDAO.insertarPelicula(pelicula); 	
    }
    
    public boolean editar(PeliculaDTO pelicula) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        return peliculaDAO.editarPelicula(pelicula);
    }

    public boolean borrar(int id) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        return peliculaDAO.borrarPelicula(id);
    }
}