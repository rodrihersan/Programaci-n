package controlador;

import java.util.ArrayList;
import modelo.ReservaDAO;
import modelo.ReservaDTO;

public class ReservaController {
	
	ReservaDAO reservaDAO = new ReservaDAO();
	
	public ArrayList<ReservaDTO> obtenerTodasLasReservas() {
        return reservaDAO.obtenerTodasLasReservas();
    }
	
	public boolean programarReserva(int idSesion, int idCliente, int numEntradas) {
		return reservaDAO.programarReserva(idSesion, idCliente, numEntradas);
	}

}
