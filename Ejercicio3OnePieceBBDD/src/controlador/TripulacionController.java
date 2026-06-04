package controlador;

import modelo.TripulacionDAO;
import modelo.TripulacionDTO;

public class TripulacionController {

    public void listarTodasLasTripulaciones() {
        TripulacionDAO tripulacionDAO = new TripulacionDAO();
        tripulacionDAO.listarTodasLasTripulaciones();
    }

    public boolean insertar(TripulacionDTO tripulacion) {
        TripulacionDAO tripulacionDAO = new TripulacionDAO();
        return tripulacionDAO.insertarTripulacion(tripulacion);
    }

    public boolean actualizar(TripulacionDTO tripulacion) {
        TripulacionDAO tripulacionDAO = new TripulacionDAO();
        return tripulacionDAO.actualizarTripulacion(tripulacion);
    }

    public boolean eliminar(long id) {
        TripulacionDAO tripulacionDAO = new TripulacionDAO();
        return tripulacionDAO.eliminarTripulacion(id);
    }
}
