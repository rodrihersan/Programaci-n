package controlador;

import java.util.ArrayList;
import modelo.SesionDAO;
import modelo.SesionDTO;

public class SesionController {
	
	SesionDAO sesionDAO = new SesionDAO();
	
	
	public ArrayList<SesionDTO> obtenerTodasLasSesiones() {
        return sesionDAO.obtenerTodasLasSesiones();
    }
	
	public boolean borrar(int id) {
        return sesionDAO.borrarSesion(id);
    }
	
	public boolean programarSesion(int idPelicula, int idSala, String fecha, String hora, double precio) {
		return sesionDAO.programarSesion(idPelicula, idSala, fecha, hora, precio);
	}
}
